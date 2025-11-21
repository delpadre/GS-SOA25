package com.example.upskilling.controller;

import com.example.upskilling.dto.CompetenciaDTO;
import com.example.upskilling.service.CompetenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/competencias")
public class CompetenciaController {

    @Autowired
    private CompetenciaService competenciaService;

    @PostMapping
    public ResponseEntity<CompetenciaDTO> create(@RequestBody CompetenciaDTO dto) {
        return ResponseEntity.status(201).body(competenciaService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<CompetenciaDTO>> getAll() {
        return ResponseEntity.ok(competenciaService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompetenciaDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(competenciaService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompetenciaDTO> update(@PathVariable Long id, @RequestBody CompetenciaDTO dto) {
        return ResponseEntity.ok(competenciaService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        competenciaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
