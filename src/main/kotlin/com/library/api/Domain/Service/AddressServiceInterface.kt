package com.library.api.Domain.Service

import com.library.api.Domain.DTOs.Request.AddressRequestDto
import com.library.api.Domain.Entities.Address

interface AddressServiceInterface {
    fun save(addressRequestDto: AddressRequestDto): Address
}