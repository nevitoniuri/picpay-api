package com.picpayapi.application.model

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "users")
data class User(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,

    val firstName: String,

    val lastName: String,

    @Column(unique = true)
    val document: String,

    @Column(unique = true)
    val email: String,

    val password: String,

    val balance: BigDecimal,

    @Enumerated(EnumType.STRING)
    val userType: UserType
)