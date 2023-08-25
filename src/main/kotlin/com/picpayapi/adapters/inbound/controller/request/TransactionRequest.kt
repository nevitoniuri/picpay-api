package com.picpayapi.adapters.inbound.controller.request

import java.math.BigDecimal

data class TransactionRequest(
    val value: BigDecimal,
    val payerId: Long,
    val payeeId: Long
)