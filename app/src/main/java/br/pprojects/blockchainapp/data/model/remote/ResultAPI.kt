package br.pprojects.blockchainapp.data.model.remote

sealed class ResultAPI<out T : Any> {
    data class Success<out T : Any>(val data: T) : ResultAPI<T>()
    data class SuccessNoBody(val message: String) : ResultAPI<Nothing>()
    data class Error(val error: ServerError) : ResultAPI<Nothing>() 
    data class InternalError(val exception: Exception) : ResultAPI<Nothing>()
}