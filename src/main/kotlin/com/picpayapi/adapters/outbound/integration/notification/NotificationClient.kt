package com.picpayapi.adapters.outbound.integration.notification

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@FeignClient(name = "notificationClient", url = "http://o4d9z.mocklab.io/notify")
fun interface NotificationClient {

    @PostMapping
    fun notify(@RequestBody notification: NotificationRequest)
}