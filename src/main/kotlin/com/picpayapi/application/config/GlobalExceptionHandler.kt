package com.picpayapi.application.config

import com.picpayapi.application.exception.BadRequestException
import com.picpayapi.application.exception.NotFoundException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException::class)
    fun notFoundHandler(ex: NotFoundException): ExceptionResponse {
        return ExceptionResponse(message = ex.message, status = HttpStatus.NOT_FOUND.value())
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException::class)
    fun badRequestHandler(ex: BadRequestException): ExceptionResponse {
        return ExceptionResponse(message = ex.message, status = HttpStatus.BAD_REQUEST.value())
    }
}