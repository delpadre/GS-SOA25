package com.example.upskilling.service.impl;

import com.example.upskilling.dto.TrilhaDTO;
import com.example.upskilling.model.Trilha;
import com.example.upskilling.model.Nivel;
import com.example.upskilling.repository.TrilhaRepository;
import com.example.upskilling.service.TrilhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrilhaServiceImpl implements TrilhaService {

    @Autowired
    private TrilhaRepository trilhaRepository;

    private TrilhaDTO toDTO(Trilha t) {
        TrilhaDTO dto = new TrilhaDTO();
        dto.setId(t.getId());
        dto.setNome(t.getNome());
        dto.setDescricao(t.getDescricao());
        dto.setNivel(t.getNivel());
        dto.setCargaHoraria(t.getCargaHoraria());
        dto.setFocoPrincipal(t.getFocoPrincipal());
        return dto;
    }

    private Trilha toEntity(TrilhaDTO dto) {
        Trilha t = new Trilha();
        t.setNome(dto.getNome());
        t.setDescricao(dto.getDescricao());
        t.setNivel(dto.getNivel());
        t.setCargaHoraria(dto.getCargaHoraria());
        t.setFocoPrincipal(dto.getFocoPrincipal());
        return t;
    }

    @Override
    public TrilhaDTO create(TrilhaDTO dto) {

        if (!Nivel.isValid(dto.getNivel())) {
            throw new IllegalArgumentException("Nível inválido (use INICIANTE, INTERMEDIARIO ou AVANCADO)");
        }

        return toDTO(trilhaRepository.save(toEntity(dto)));
    }

    @Override
    public TrilhaDTO update(Long id, TrilhaDTO dto) {

        Trilha t = trilhaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trilha não encontrada"));

        if (!Nivel.isValid(dto.getNivel())) {
            throw new IllegalArgumentException("Nível inválido.");
        }

        t.setNome(dto.getNome());
        t.setDescricao(dto.getDescricao());
        t.setNivel(dto.getNivel());
        t.setCargaHoraria(dto.getCargaHoraria());
        t.setFocoPrincipal(dto.getFocoPrincipal());

        return toDTO(trilhaRepository.save(t));
    }

    @Override
    public void delete(Long id) {
        trilhaRepository.deleteById(id);
    }

    @Override
    public TrilhaDTO getById(Long id) {
        return trilhaRepository.findById(id)
                .map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("Trilha não encontrada"));
    }

    @Override
    public List<TrilhaDTO> getAll() {
        return trilhaRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }
}
