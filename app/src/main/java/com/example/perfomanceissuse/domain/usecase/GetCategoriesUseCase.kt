package com.example.perfomanceissuse.domain.usecase

import com.example.perfomanceissuse.data.repository.CategoryFakeRepositoryImpl
import com.example.perfomanceissuse.domain.MyResult
import com.example.perfomanceissuse.domain.repository.CategoryRepository
import kotlinx.coroutines.flow.flow

class GetCategoriesUseCase {
    private val repository: CategoryRepository = CategoryFakeRepositoryImpl()

    suspend operator fun invoke() = flow {
        emit(MyResult.Loading)
        val result = try {
            val response = repository.getAllCategories()
            MyResult.Success(response)
        } catch (e: Exception) {
            MyResult.Error(e)
        }
        emit(result)
    }
}
