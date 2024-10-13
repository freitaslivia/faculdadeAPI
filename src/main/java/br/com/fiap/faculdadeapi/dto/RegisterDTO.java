package br.com.fiap.faculdadeapi.dto;

import br.com.fiap.faculdadeapi.model.UserRole;

public record RegisterDTO(String login,
                          String senha,
                          UserRole role) {}