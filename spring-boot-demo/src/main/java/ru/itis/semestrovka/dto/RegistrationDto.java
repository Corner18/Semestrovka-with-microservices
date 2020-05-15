package ru.itis.semestrovka.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class RegistrationDto {

    @NotBlank(message = "{errors.null.name}")
    private String name;

    @Email(message = "{errors.incorrect.email}")
    @NotBlank(message = "{errors.null.email}")
    private String email;

    @NotBlank(message = "{errors.null.password}")
    private String password;

    @NotBlank(message = "{errors.null.phone}")
    private String phoneNumber;
}

