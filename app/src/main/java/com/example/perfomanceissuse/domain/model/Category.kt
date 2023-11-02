package com.example.perfomanceissuse.domain.model

sealed class Category(
    val id: String,
    val name: String,
    val products: List<Product>,
) {
    class Category1(id: String, name: String, products: List<Product>) : Category(id, name, products)
    class Category2(id: String, name: String, products: List<Product>) : Category(id, name, products)
    class Category3(id: String, name: String, products: List<Product>) : Category(id, name, products)
}
