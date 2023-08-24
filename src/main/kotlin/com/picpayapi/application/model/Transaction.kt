package com.picpayapi.application.model

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
@Table(name = "transactions")
class Transaction(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val value: BigDecimal,

    @ManyToOne
    @JoinColumn(name = "payer_id")
    val payer: User,

    @ManyToOne
    @JoinColumn(name = "payee_id")
    val payee: User,

    val timestamp: LocalDateTime = LocalDateTime.now(),

    val success: Boolean? = true
)