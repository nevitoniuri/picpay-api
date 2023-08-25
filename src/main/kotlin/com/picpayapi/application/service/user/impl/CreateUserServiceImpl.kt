package com.picpayapi.application.service.user.impl

import com.picpayapi.adapters.entity.User
import com.picpayapi.adapters.outbound.repository.UserRepository
import com.picpayapi.application.exception.BadRequestException
import com.picpayapi.application.service.user.CreateUserService
import com.picpayapi.application.service.user.FindUserByDocumentOrEmailService
import org.springframework.stereotype.Service

@Service
class CreateUserServiceImpl(
    private val userRepository: UserRepository,
    private val findUserByDocumentOrEmailService: FindUserByDocumentOrEmailService
) : CreateUserService {

    override fun execute(user: User): User {
        findUserByDocumentOrEmailService.execute(user.document, user.email).ifPresent {
            throw BadRequestException("User already exists")
        }
        return userRepository.save(user)
    }
}