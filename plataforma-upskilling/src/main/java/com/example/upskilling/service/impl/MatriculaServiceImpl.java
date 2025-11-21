package com.example.upskilling.service.impl;

import com.example.upskilling.dto.MatriculaDTO;
import com.example.upskilling.exception.UsuarioNaoElegivelParaTrilhaException;
import com.example.upskilling.model.Matricula;
import com.example.upskilling.model.Trilha;
import com.example.upskilling.model.Usuario;
import com.example.upskilling.repository.MatriculaRepository;
import com.example.upskilling.repository.TrilhaRepository;
import com.example.upskilling.repository.UsuarioRepository;
import com.example.upskilling.service.MatriculaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MatriculaServiceImpl implements MatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TrilhaRepository trilhaRepository;

    // Converter Matricula para DTO
    private MatriculaDTO toDTO(Matricula m) {
        MatriculaDTO dto = new MatriculaDTO();
        dto.setId(m.getId());
        dto.setUsuarioId(m.getUsuario().getId());
        dto.setTrilhaId(m.getTrilha().getId());
        dto.setStatus(m.getStatus());
        return dto;
    }

    @Override
    public MatriculaDTO create(MatriculaDTO dto) {
        Usuario u = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Trilha t = trilhaRepository.findById(dto.getTrilhaId())
                .orElseThrow(() -> new RuntimeException("Trilha não encontrada"));

        boolean jaMatriculado = matriculaRepository.findByUsuarioId(u.getId())
                .stream()
                .anyMatch(m -> m.getTrilha().getId().equals(t.getId()));

        if (jaMatriculado) {
            throw new UsuarioNaoElegivelParaTrilhaException("O usuário já está matriculado nesta trilha.");
        }

        Matricula m = new Matricula();
        m.setUsuario(u);
        m.setTrilha(t);
        m.setDataInscricao(LocalDate.now());
        m.setStatus(dto.getStatus());

        return toDTO(matriculaRepository.save(m));
    }

    @Override
    public List<MatriculaDTO> getByUsuario(Long usuarioId) {
        return matriculaRepository.findByUsuarioId(usuarioId)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<MatriculaDTO> getAll() {
        return matriculaRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MatriculaDTO getById(Long id) {
        Matricula m = matriculaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Matrícula não encontrada"));
        return toDTO(m);
    }

    @Override
    public MatriculaDTO update(Long id, MatriculaDTO dto) {
        Matricula m = matriculaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Matrícula não encontrada"));

        m.setStatus(dto.getStatus());

        return toDTO(matriculaRepository.save(m));
    }

    // --- NOVO MÉTODO ADICIONADO PARA CORRIGIR O ERRO ---
    @Override
    public void delete(Long id) {
        if (!matriculaRepository.existsById(id)) {
            throw new RuntimeException("Matrícula não encontrada para exclusão");
        }
        matriculaRepository.deleteById(id);
    }
}