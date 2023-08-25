package com.picpayapi.adapters.utils

import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI

fun getResourceUri(resourceId: Long): URI =
    ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(resourceId)
        .toUri()