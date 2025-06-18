package com.store.panel.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class CustomerDTO {
    private Long id;

    @NotBlank
    private String name;

    @Email
    @NotBlank
    private String email;
}