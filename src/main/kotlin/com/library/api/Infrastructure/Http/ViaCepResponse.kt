package com.library.api.Infrastructure.Http

import com.fasterxml.jackson.annotation.JsonAlias

class ViaCepResponse {

    @JsonAlias("logradouro")
    val neighborhood: String? = null
}