package com.picpayapi.adapters.dto.request

import jakarta.validation.constraints.NotNull
import java.math.BigDecimal

data class TransactionCreateRequest(
    @field:NotNull val value: BigDecimal,
    @field:NotNull val payerId: Long,
    @field:NotNull val payeeId: Long
)
