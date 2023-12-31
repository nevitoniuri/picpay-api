package com.picpayapi.adapters.outbound.repository

import com.picpayapi.adapters.entity.Transaction
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TransactionRepository : JpaRepository<Transaction, Long>