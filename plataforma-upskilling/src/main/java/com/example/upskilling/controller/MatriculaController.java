package com.example.upskilling.controller;

import com.example.upskilling.dto.MatriculaDTO;
import com.example.upskilling.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaService matriculaService;

    @PostMapping
    public ResponseEntity<MatriculaDTO> create(@RequestBody MatriculaDTO dto) {
        return ResponseEntity.status(201).body(matriculaService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<MatriculaDTO>> getAll() {
        return ResponseEntity.ok(matriculaService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatriculaDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(matriculaService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MatriculaDTO> update(@PathVariable Long id, @RequestBody MatriculaDTO dto) {
        return ResponseEntity.ok(matriculaService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        matriculaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
