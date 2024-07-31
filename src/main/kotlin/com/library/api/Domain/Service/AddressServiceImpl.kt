package com.library.api.Domain.Service

import com.library.api.Domain.DTOs.Request.AddressRequestDto
import com.library.api.Domain.Entities.Address
import com.library.api.Domain.Exception.UserNotFoundException
import com.library.api.Infrastructure.Http.ViaCep
import com.library.api.Infrastructure.Repository.AddressRepository
import com.library.api.Infrastructure.Repository.AuthorRepository
import org.springframework.stereotype.Service

@Service
class AddressServiceImpl(
    val addressRepository: AddressRepository,
    val authorRepository: AuthorRepository,
    val viaCep: ViaCep
) : AddressServiceInterface {

    override fun save(addressRequestDto: AddressRequestDto): Address {

        val author = authorRepository.findById(addressRequestDto.author)
            .orElseThrow {
                UserNotFoundException("User not found with id ${addressRequestDto.author}")
            }
        val address = addressRepository.save(
            Address(
                cep = addressRequestDto.cep,
                neighborhood = viaCep.viaCep(addressRequestDto.cep).body?.neighborhood,
                author = author,
            )
        );

        return Address.fromDomain(address);
    }
}