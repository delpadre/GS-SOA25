package com.example.upskilling.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;

public class MatriculaDTO {

    private Long id;

    @NotNull(message = "O usuário é obrigatório.")
    private Long usuarioId;

    @NotNull(message = "A trilha é obrigatória.")
    private Long trilhaId;

    @NotBlank(message = "O status é obrigatório (ATIVA, CONCLUIDA, CANCELADA).")
    private String status;

    private String nivel;

    public MatriculaDTO() {}

    // Getters / Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }

    public Long getTrilhaId() { return trilhaId; }
    public void setTrilhaId(Long trilhaId) { this.trilhaId = trilhaId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getNivel() { return nivel; }
    public void setNivel(String nivel) { this.nivel = nivel; }
}
