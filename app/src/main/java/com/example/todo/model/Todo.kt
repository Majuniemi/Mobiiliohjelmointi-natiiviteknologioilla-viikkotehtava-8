package com.example.todo.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

data class Success(val todos: List<Todo>)

data class Todo(

    val userId: Int,
    val id: Int,
    val title: String,
    val completed: Boolean
)

const val BASE_URL = "https://jsonplaceholder.typicode.com"

    interface TodosApi {
    @GET("/todos")
    suspend fun getTodos(): List<Todo>

    companion object {
        var todoService: TodosApi? = null

        fun getInstance(): TodosApi {
            if (todoService === null) {
                todoService = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(TodosApi::class.java)
            }
            return todoService!!
        }
    }
}




