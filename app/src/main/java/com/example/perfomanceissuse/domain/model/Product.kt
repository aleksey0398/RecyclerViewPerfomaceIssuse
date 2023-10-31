package com.example.perfomanceissuse.domain.model

import java.util.UUID

class Product(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val imageUrl: String?,
    val priceNew: String,
    val priceOld: String,
)
