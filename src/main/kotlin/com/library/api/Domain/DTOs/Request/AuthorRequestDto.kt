package com.library.api.Domain.DTOs.Request
import jakarta.validation.constraints.NotNull

data class AuthorRequestDto (

    @NotNull(message = "O nome não pode ser vazio.")
    val name: String,

    val books: MutableList<BookRequestDto>
)