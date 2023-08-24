package com.picpayapi.application.service.transaction.impl

import com.picpayapi.adapter.outbound.integration.TransactionAuthorizationClient
import com.picpayapi.adapter.outbound.repository.TransactionRepository
import com.picpayapi.application.model.Transaction
import com.picpayapi.application.model.UserType
import com.picpayapi.application.service.transaction.CreateTransactionService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.math.BigDecimal

@Service
class CreateTransactionServiceImpl(
    private val transactionRepository: TransactionRepository,
    private val transactionAuthorizationClient: TransactionAuthorizationClient
) : CreateTransactionService {

    @Transactional
    override fun execute(transaction: Transaction) {
        validateTransaction(transaction)
        authorizeTransaction(transaction)
        transactionRepository.save(transaction)
    }

    fun validateTransaction(transaction: Transaction) {
        if (transaction.value <= BigDecimal.ZERO) {
            throw Exception("Invalid transaction value")
        }
        if (transaction.payer.id == transaction.payee.id) {
            throw Exception("Payer and payee must be different")
        }
        if (transaction.payer.userType == UserType.MERCHANT) {
            throw Exception("Merchant can't be payer")
        }
    }

    fun authorizeTransaction(transaction: Transaction) {
        val transactionAuthorizationResponse = transactionAuthorizationClient.authorize()
        if (transactionAuthorizationResponse.message != "Autorizado") {
            throw Exception("Transaction not authorized")
        }
    }

}