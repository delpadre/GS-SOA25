package com.example.upskilling.repository;

import com.example.upskilling.model.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {

    List<Matricula> findByUsuarioId(Long usuarioId);

}
