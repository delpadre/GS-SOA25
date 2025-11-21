package com.example.upskilling.service;

import com.example.upskilling.dto.TrilhaDTO;
import java.util.List;

public interface TrilhaService {

    TrilhaDTO create(TrilhaDTO dto);
    TrilhaDTO update(Long id, TrilhaDTO dto);
    void delete(Long id);
    TrilhaDTO getById(Long id);
    List<TrilhaDTO> getAll();
}
