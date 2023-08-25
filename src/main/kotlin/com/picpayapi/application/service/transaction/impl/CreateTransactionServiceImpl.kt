package com.picpayapi.application.service.transaction.impl

import com.picpayapi.adapters.outbound.integration.authorization.TransactionAuthorizationClient
import com.picpayapi.adapters.outbound.repository.TransactionRepository
import com.picpayapi.adapters.entity.Transaction
import com.picpayapi.adapters.entity.UserType
import com.picpayapi.application.service.notification.SendNotificationService
import com.picpayapi.application.service.transaction.CreateTransactionService
import com.picpayapi.application.service.user.UpdateUsersBalance
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.math.BigDecimal

@Service
class CreateTransactionServiceImpl(
    private val transactionRepository: TransactionRepository,
    private val transactionAuthorizationClient: TransactionAuthorizationClient,
    private val updateUsersBalance: UpdateUsersBalance,
    private val sendNotificationService: SendNotificationService
) : CreateTransactionService {

    @Transactional
    override fun execute(transaction: Transaction) {
        validateTransaction(transaction)
        authorizeTransaction(transaction)
        updateUsersBalance.execute(transaction)
        transactionRepository.save(transaction)
        sendNotificationService.execute(transaction)
    }

    fun validateTransaction(transaction: Transaction) {
        if (transaction.value <= BigDecimal.ZERO) {
            throw Exception("Invalid transaction value")
        }
        if (transaction.payer.balance < transaction.value) {
            throw Exception("Insufficient balance")
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