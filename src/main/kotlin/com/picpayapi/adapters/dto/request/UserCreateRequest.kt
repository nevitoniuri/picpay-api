package com.picpayapi.adapters.dto.request

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size
import org.hibernate.validator.constraints.br.CPF

data class UserCreateRequest(
    @field:NotBlank
    @field:Size(min = 3, max = 50)
    val firstName: String,

    @field:NotBlank
    @field:Size(min = 3, max = 50)
    val lastName: String,

    @field:CPF
    @field:NotBlank
    val document: String,

    @field:Email
    @field:NotBlank
    val email: String,

    @field:NotBlank
    val password: String
)
