package com.picpayapi.application.service.user.impl

import com.picpayapi.adapter.outbound.repository.UserRepository
import com.picpayapi.application.model.Transaction
import com.picpayapi.application.service.user.UpdateUsersBalance
import org.springframework.stereotype.Service

@Service
class UpdateUsersBalanceImpl(
    private val userRepository: UserRepository
) : UpdateUsersBalance {
    override fun execute(transaction: Transaction) {
        val payer = transaction.payer
        val payee = transaction.payee
        val updatedPayer = payer.copy(balance = payer.balance.subtract(transaction.value))
        val updatedPayee = payee.copy(balance = payee.balance.add(transaction.value))
        userRepository.saveAll(listOf(updatedPayer, updatedPayee))
    }
}