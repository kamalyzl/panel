package com.store.panel.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDTO {

    private Long id;

    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name must be at most 100 characters")
    private String name;

    @NotBlank(message = "Lastname is required")
    @Size(max = 100, message = "Lastname must be at most 100 characters")
    private String lastname;

    @NotBlank(message = "DNI is required")
    @Size(min = 8, max = 8, message = "DNI must be 8 characters")
    private String dni;

    @Size(max = 255, message = "Address must be at most 255 characters")
    private String address;

    @Size(max = 20, message = "Phone number must be at most 20 characters")
    private String numberPhone;

    @Email(message = "Email must be valid")
    @Size(max = 255, message = "Email must be at most 255 characters")
    private String email;
}
