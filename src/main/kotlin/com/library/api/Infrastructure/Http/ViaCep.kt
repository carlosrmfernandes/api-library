package com.library.api.Infrastructure.Http

import com.library.api.Config.Services
import com.library.api.Domain.Exception.AddressNotFoundException
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.client.RestClient

@Service
class ViaCep(
    services: Services,
    restClientBuilder: RestClient.Builder
) {
    private val restClient = restClientBuilder.baseUrl(
        services.service()["via_cep"].toString()
    ).build()

    fun viaCep(cep: String): ResponseEntity<ViaCepResponse> {
        try {
            return restClient.get()
                .uri("/{cep}/json", cep)
                .retrieve()
                .toEntity(ViaCepResponse::class.java)
        } catch (ex: Exception) {
            throw AddressNotFoundException("CEP not found ${cep}")
        }

    }
}

