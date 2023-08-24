package com.picpayapi.application.service.user.impl

import com.picpayapi.adapter.outbound.repository.UserRepository
import com.picpayapi.application.model.User
import com.picpayapi.application.service.user.CreateUserService
import org.springframework.stereotype.Service

@Service
class CreateUserServiceImpl(
    private val userRepository: UserRepository
) : CreateUserService {

    override fun execute(user: User) {
        userRepository.save(user)
    }

}