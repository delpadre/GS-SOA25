package com.example.upskilling.controller;

import com.example.upskilling.dto.TrilhaDTO;
import com.example.upskilling.model.Nivel;
import com.example.upskilling.service.TrilhaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trilhas")
public class TrilhaController {

    @Autowired
    private TrilhaService trilhaService;

    @PostMapping
    public ResponseEntity<TrilhaDTO> create(@RequestBody TrilhaDTO dto) {
        return ResponseEntity.status(201).body(trilhaService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<TrilhaDTO>> getAll() {
        return ResponseEntity.ok(trilhaService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrilhaDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(trilhaService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrilhaDTO> update(@PathVariable Long id, @RequestBody TrilhaDTO dto) {
        return ResponseEntity.ok(trilhaService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        trilhaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
