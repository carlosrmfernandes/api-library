package com.library.api.Domain.DTOs.Response

import com.library.api.Domain.Entities.Book

data class BookResponseDto(
    val id: Long? = null,
    val description: String? = null,
){
    companion object {
        fun toDomain(book: Book): BookResponseDto {
            return BookResponseDto(
                id = book.id,
                description = book.description,
            )
        }
    }
}