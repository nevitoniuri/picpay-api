package com.picpayapi.application.service.user.impl

import com.picpayapi.adapters.entity.User
import com.picpayapi.adapters.outbound.repository.UserRepository
import com.picpayapi.application.service.user.FindUserByDocumentOrEmailService
import org.springframework.stereotype.Service
import java.util.*

@Service
class FindUserByDocumentOrEmailServiceImpl(
    private val userRepository: UserRepository
) : FindUserByDocumentOrEmailService {

    override fun execute(document: String, email: String): Optional<User> {
        return userRepository.findUserByDocumentOrEmail(document, email)
    }
}