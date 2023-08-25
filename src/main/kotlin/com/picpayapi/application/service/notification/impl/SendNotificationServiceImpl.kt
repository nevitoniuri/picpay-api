package com.picpayapi.application.service.notification.impl

import com.picpayapi.adapters.entity.Transaction
import com.picpayapi.adapters.outbound.integration.notification.NotificationClient
import com.picpayapi.adapters.outbound.integration.notification.NotificationRequest
import com.picpayapi.application.service.notification.SendNotificationService
import org.springframework.stereotype.Service

@Service
class SendNotificationServiceImpl(
    private val notificationClient: NotificationClient
) : SendNotificationService {

    override fun execute(transaction: Transaction) {
        notificationClient.notify(
            NotificationRequest(
                email = transaction.payee.email,
                message = "You received a payment of ${transaction.value} from ${transaction.payer.firstName} ${transaction.payer.lastName}"
            )
        )
    }
}
