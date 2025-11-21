package com.example.upskilling.service;

import com.example.upskilling.dto.CompetenciaDTO;
import java.util.List;

public interface CompetenciaService {

    CompetenciaDTO create(CompetenciaDTO dto);
    CompetenciaDTO update(Long id, CompetenciaDTO dto);
    void delete(Long id);
    CompetenciaDTO getById(Long id);
    List<CompetenciaDTO> getAll();
}
