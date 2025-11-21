package com.example.upskilling.service.impl;

import com.example.upskilling.dto.CompetenciaDTO;
import com.example.upskilling.model.Competencia;
import com.example.upskilling.repository.CompetenciaRepository;
import com.example.upskilling.service.CompetenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompetenciaServiceImpl implements CompetenciaService {

    @Autowired
    private CompetenciaRepository competenciaRepository;

    private CompetenciaDTO toDTO(Competencia c) {
        CompetenciaDTO dto = new CompetenciaDTO();
        dto.setId(c.getId());
        dto.setNome(c.getNome());
        dto.setCategoria(c.getCategoria());
        dto.setDescricao(c.getDescricao());
        return dto;
    }

    private Competencia toEntity(CompetenciaDTO dto) {
        Competencia c = new Competencia();
        c.setNome(dto.getNome());
        c.setCategoria(dto.getCategoria());
        c.setDescricao(dto.getDescricao());
        return c;
    }

    @Override
    public CompetenciaDTO create(CompetenciaDTO dto) {
        Competencia c = toEntity(dto);
        return toDTO(competenciaRepository.save(c));
    }

    @Override
    public CompetenciaDTO update(Long id, CompetenciaDTO dto) {
        Competencia c = competenciaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Competência não encontrada"));

        c.setNome(dto.getNome());
        c.setCategoria(dto.getCategoria());
        c.setDescricao(dto.getDescricao());

        return toDTO(competenciaRepository.save(c));
    }

    @Override
    public void delete(Long id) {
        competenciaRepository.deleteById(id);
    }

    @Override
    public CompetenciaDTO getById(Long id) {
        return competenciaRepository.findById(id)
                .map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("Competência não encontrada"));
    }

    @Override
    public List<CompetenciaDTO> getAll() {
        return competenciaRepository.findAll()
                .stream().map(this::toDTO).collect(Collectors.toList());
    }
}
