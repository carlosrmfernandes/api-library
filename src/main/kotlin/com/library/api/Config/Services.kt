package com.library.api.Config

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class Services {
    val services = mapOf(
        "via_cep" to "https://viacep.com.br/ws"
    );

    fun service(): Map<String, String> {
        return services;
    }
}
