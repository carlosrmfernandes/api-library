package com.library.api.Domain.DTOs.Request

import com.fasterxml.jackson.annotation.JsonAlias

data class AddressRequestDto (
    val cep: String,
    @JsonAlias("author_id")
    val author: Long,
)