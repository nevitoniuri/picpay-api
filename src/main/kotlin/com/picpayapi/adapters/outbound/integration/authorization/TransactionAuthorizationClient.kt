package com.picpayapi.adapters.outbound.integration.authorization

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

@FeignClient(name = "transaction-authorization", url = "https://run.mocky.io/v3/8fafdd68-a090-496f-8c9a-3442cf30dae6")
fun interface TransactionAuthorizationClient {
    @GetMapping
    fun authorize(): TransactionAuthorizationResponse
}