package com.example.upskilling.service.impl;

import com.example.upskilling.dto.UsuarioDTO;
import com.example.upskilling.model.Usuario;
import com.example.upskilling.repository.UsuarioRepository;
import com.example.upskilling.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private UsuarioDTO toDTO(Usuario u) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(u.getId());
        dto.setNome(u.getNome());
        dto.setEmail(u.getEmail());
        dto.setAreaAtuacao(u.getAreaAtuacao());
        dto.setNivelCarreira(u.getNivelCarreira());
        return dto;
    }

    private Usuario toEntity(UsuarioDTO dto) {
        Usuario u = new Usuario();
        u.setNome(dto.getNome());
        u.setEmail(dto.getEmail());
        u.setAreaAtuacao(dto.getAreaAtuacao());
        u.setNivelCarreira(dto.getNivelCarreira());
        return u;
    }

    @Override
    public UsuarioDTO create(UsuarioDTO dto) {
        Usuario u = toEntity(dto);
        u.setDataCadastro(LocalDate.now());
        return toDTO(usuarioRepository.save(u));
    }

    @Override
    public UsuarioDTO update(Long id, UsuarioDTO dto) {
        Usuario u = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        u.setNome(dto.getNome());
        u.setEmail(dto.getEmail());
        u.setAreaAtuacao(dto.getAreaAtuacao());
        u.setNivelCarreira(dto.getNivelCarreira());

        return toDTO(usuarioRepository.save(u));
    }

    @Override
    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public UsuarioDTO getById(Long id) {
        return usuarioRepository.findById(id)
                .map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    @Override
    public List<UsuarioDTO> getAll() {
        return usuarioRepository.findAll()
                .stream().map(this::toDTO).collect(Collectors.toList());
    }
}
