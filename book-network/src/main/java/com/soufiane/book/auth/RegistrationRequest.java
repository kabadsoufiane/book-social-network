package com.soufiane.book.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class RegistrationRequest {

    @NotEmpty(message = "Firstname is Mandatory")
    @NotBlank(message = "Firstname is Mandatory")
    private String firstname;
    @NotEmpty(message = "Lastname is Mandatory")
    @NotBlank(message = "Lastname is Mandatory")
    private String lastname;
    @Email(message = "Email is not formatted")
    @NotEmpty(message = "Email is Mandatory")
    @NotBlank(message = "Email is Mandatory")
    private String email;
    @NotEmpty(message = "Password is Mandatory")
    @NotBlank(message = "Password is Mandatory")
    @Size(min = 8, message = "Password should be 8 characters long minimum")
    private String password;

}
