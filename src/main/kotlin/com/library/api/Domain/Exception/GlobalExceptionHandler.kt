package com.library.api.Domain.Exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException::class)
    fun userNotFoundException(ex: Exception): ResponseEntity<ErrorException> {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorException(ex.message));
    }

    @ExceptionHandler(AddressNotFoundException::class)
    fun addressNotFoundException(ex: Exception): ResponseEntity<ErrorException> {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorException(ex.message));
    }
}