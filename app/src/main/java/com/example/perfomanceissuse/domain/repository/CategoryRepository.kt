package com.example.perfomanceissuse.domain.repository

import com.example.perfomanceissuse.domain.model.Category
import com.example.perfomanceissuse.domain.model.Product

interface CategoryRepository {

    suspend fun getAllCategories(): List<Category>
}
