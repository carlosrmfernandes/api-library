package com.library.api.controller

import com.library.api.Domain.DTOs.Response.BookResponseDto
import com.library.api.Domain.Entities.Book
import com.library.api.Domain.Service.BookServiceInterface
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/book")
class BookController(
    private val bookServiceInterface: BookServiceInterface,

) {

    @GetMapping("/{id}")
    fun getAuthor(@PathVariable id: Long): ResponseEntity<BookResponseDto> {
        val book = bookServiceInterface.findById(id)
        return ResponseEntity.status(HttpStatus.OK).body(
            BookResponseDto.toDomain(book)
        );
    }
}