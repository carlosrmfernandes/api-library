package com.library.api.Domain.DTOs.Response

import com.library.api.Domain.Entities.Author

data class AuthorResponseDto(
    val id: Long? = null,
    val name: String? = null,
    val book: List<BookResponseDto>? = null
){
    companion object {
        fun fromDomain(author: Author): AuthorResponseDto {
            return AuthorResponseDto(
                id = author.id,
                name = author.name,
                book = author.books?.map { BookResponseDto.toDomain(it) }
            )
        }
    }
}
