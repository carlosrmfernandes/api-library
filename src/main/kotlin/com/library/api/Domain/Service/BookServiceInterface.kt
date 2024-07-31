package com.library.api.Domain.Service

import com.library.api.Domain.Entities.Author
import com.library.api.Domain.Entities.Book
import com.library.api.Domain.DTOs.Request.AuthorRequestDto
import java.util.*

interface BookServiceInterface {

    fun saveAll(authorRequestDto: AuthorRequestDto, author: Author): MutableIterable<Book>
    fun findById(id: Long): Book
}