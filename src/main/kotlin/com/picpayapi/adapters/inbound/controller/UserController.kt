package com.picpayapi.adapters.inbound.controller

import com.picpayapi.adapters.dto.request.UserCreateRequest
import com.picpayapi.adapters.dto.response.UserResponse
import com.picpayapi.adapters.mapper.toResponse
import com.picpayapi.adapters.mapper.toUser
import com.picpayapi.adapters.utils.getResourceUri
import com.picpayapi.application.service.user.CreateUserService
import com.picpayapi.application.service.user.FindUserByIdService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("v1/user")
class UserController(
    private val createUserService: CreateUserService,
    private val findUserByIdService: FindUserByIdService
) {

    @GetMapping("{id}")
    fun getUserById(@PathVariable id: Long): UserResponse {
        return findUserByIdService.execute(id).toResponse()
    }

    @PostMapping
    fun createUser(@RequestBody @Valid userCreateRequest: UserCreateRequest): ResponseEntity<Unit> {
        val createdUser = createUserService.execute(userCreateRequest.toUser())
        return ResponseEntity.created(getResourceUri(createdUser.id!!)).build()
    }
}