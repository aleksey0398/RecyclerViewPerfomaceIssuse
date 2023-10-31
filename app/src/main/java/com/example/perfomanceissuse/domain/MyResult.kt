package com.example.perfomanceissuse.domain

sealed class MyResult<out T> {
    object Loading : MyResult<Nothing>()
    data class Success<R>(val data: R) : MyResult<R>()
    data class Error(val exception: Exception) : MyResult<Nothing>()
}
