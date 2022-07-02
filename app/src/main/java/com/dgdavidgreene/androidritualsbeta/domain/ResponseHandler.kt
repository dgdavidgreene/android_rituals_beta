package com.dgdavidgreene.androidritualsbeta.domain

sealed class ResponseHandler<T>(val data: T? = null, val message: StringHandler? = null) {
    class Success<T>(data: T?): ResponseHandler<T>(data)
    class Error<T>(message: StringHandler, data: T? = null): ResponseHandler<T>(data, message)
}