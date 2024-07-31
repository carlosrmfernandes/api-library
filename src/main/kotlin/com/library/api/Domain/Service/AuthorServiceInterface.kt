package com.library.api.Domain.Service

import com.library.api.Domain.Entities.Author
import com.library.api.Domain.DTOs.Request.AuthorRequestDto
import java.util.Optional

interface AuthorServiceInterface {

    fun save(authorRequestDto: AuthorRequestDto): Author
    fun findById(id: Long): Author
    fun findByName(name: String): List<Author>
    fun getAuthorsByBooks(id: Long): Author
}