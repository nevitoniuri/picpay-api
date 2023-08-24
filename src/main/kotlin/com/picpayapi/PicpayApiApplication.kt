package com.picpayapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients
@SpringBootApplication
class PicpayApiApplication

fun main(args: Array<String>) {
    runApplication<PicpayApiApplication>(*args)
}
