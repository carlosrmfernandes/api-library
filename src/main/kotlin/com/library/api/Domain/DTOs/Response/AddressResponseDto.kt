package com.library.api.Domain.DTOs.Response

import com.library.api.Domain.Entities.Address

data class AddressResponseDto(
    var id: Long? = null,
    val cep: String? = null,
    val neighborhood: String? = null

){
    companion object {
        fun fromDomain(address: Address): AddressResponseDto {
            return AddressResponseDto(
                id = address.id,
                cep = address.cep,
                neighborhood = address.neighborhood,
            )
        }
    }
}
