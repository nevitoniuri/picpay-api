package com.picpayapi.adapters.dto.request

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size
import org.hibernate.validator.constraints.br.CPF

data class UserCreateRequest(
    @NotBlank
    @Size(min = 3, max = 50)
    val firstName: String,

    @NotBlank
    @Size(min = 3, max = 50)
    val lastName: String,

    @CPF
    @NotBlank
    val document: String,

    @Email
    @NotBlank
    val email: String,

    @NotBlank
    val password: String
)
