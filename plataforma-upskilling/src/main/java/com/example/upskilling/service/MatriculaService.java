package com.example.upskilling.service;

import com.example.upskilling.dto.MatriculaDTO;

import java.util.List;

public interface MatriculaService {
    MatriculaDTO create(MatriculaDTO dto);
    List<MatriculaDTO> getByUsuario(Long usuarioId);

    // adicione estes métodos se forem usados no controller
    List<MatriculaDTO> getAll();
    MatriculaDTO getById(Long id);
    MatriculaDTO update(Long id, MatriculaDTO dto);
    void delete(Long id);
}
