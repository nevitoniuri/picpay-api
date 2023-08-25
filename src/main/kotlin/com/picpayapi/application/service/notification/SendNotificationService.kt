package com.picpayapi.application.service.notification

import com.picpayapi.adapters.entity.Transaction

fun interface SendNotificationService {
    fun execute(transaction: Transaction)
}