package com.library.api.controller

import com.library.api.Domain.DTOs.Request.AuthorRequestDto
import com.library.api.Domain.DTOs.Response.AuthorResponseDto
import com.library.api.Domain.Service.AuthorServiceInterface
import jakarta.servlet.http.HttpServletRequest
import jakarta.validation.Valid

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/author")
class AuthorController(
    private val authorServiceInterface: AuthorServiceInterface,

) {

    @PostMapping
    fun author(@RequestBody @Valid authorRequestDto: AuthorRequestDto): ResponseEntity<AuthorResponseDto> {
        val author = authorServiceInterface.save(authorRequestDto)
        return ResponseEntity.status(HttpStatus.CREATED).body(
            AuthorResponseDto.fromDomain(author)
        );
    }

    @GetMapping("/{id}")
    fun getAuthor(@PathVariable id: Long): ResponseEntity<AuthorResponseDto> {
        val author = authorServiceInterface.findById(id)
        return ResponseEntity.status(HttpStatus.OK).body(
            AuthorResponseDto.fromDomain(author)
        );
    }

    @GetMapping("name/{name}")
    fun getAuthorByName(@PathVariable name: String, request: HttpServletRequest): ResponseEntity<List<AuthorResponseDto>> {
        val authors = authorServiceInterface.findByName(name)
        return ResponseEntity.status(HttpStatus.OK).body(
            authors.map { author -> AuthorResponseDto.fromDomain(author) }
        )
    }

    @GetMapping("author/{id}")
    fun getAuthorByName(@PathVariable id: Long, request: HttpServletRequest): ResponseEntity<AuthorResponseDto> {
        val author = authorServiceInterface.getAuthorsByBooks(id)
        return ResponseEntity.status(HttpStatus.OK).body(
            AuthorResponseDto.fromDomain(author)
        );
    }
}