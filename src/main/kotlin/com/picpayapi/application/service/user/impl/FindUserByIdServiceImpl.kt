package com.picpayapi.application.service.user.impl

import com.picpayapi.adapter.outbound.repository.UserRepository
import com.picpayapi.application.model.User
import com.picpayapi.application.service.user.FindUserByIdService
import org.springframework.stereotype.Service

@Service
class FindUserByIdServiceImpl(
    private val userRepository: UserRepository
) : FindUserByIdService {

    override fun execute(id: Long): User {
        return userRepository.findById(id).orElseThrow {
            Exception("User not found")
        }
    }

}