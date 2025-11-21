package com.example.upskilling.service;

import com.example.upskilling.dto.UsuarioDTO;
import java.util.List;

public interface UsuarioService {

    UsuarioDTO create(UsuarioDTO dto);
    UsuarioDTO update(Long id, UsuarioDTO dto);
    void delete(Long id);
    UsuarioDTO getById(Long id);
    List<UsuarioDTO> getAll();
}
