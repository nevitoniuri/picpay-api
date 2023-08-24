package com.picpayapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PicpayApiApplication

fun main(args: Array<String>) {
	runApplication<PicpayApiApplication>(*args)
}
