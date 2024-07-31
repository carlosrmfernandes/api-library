package com.library.api.controller

import com.library.api.Domain.DTOs.Request.AddressRequestDto
import com.library.api.Domain.DTOs.Response.AddressResponseDto
import com.library.api.Domain.Entities.Address
import com.library.api.Domain.Service.AddressServiceInterface
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/address")
class AdrressController(
    private val addressServiceInterface: AddressServiceInterface,
) {
    @PostMapping
    fun address(@RequestBody addressRequestDto: AddressRequestDto): ResponseEntity<AddressResponseDto> {
        val address = addressServiceInterface.save(addressRequestDto)
        return ResponseEntity.status(HttpStatus.CREATED).body(
            AddressResponseDto.fromDomain(address)
        );
    }

}


