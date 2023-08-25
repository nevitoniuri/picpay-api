package com.picpayapi.adapters.dto.request

import java.math.BigDecimal

data class TransactionCreateRequest(
    val value: BigDecimal,
    val payerId: Long,
    val payeeId: Long
)
