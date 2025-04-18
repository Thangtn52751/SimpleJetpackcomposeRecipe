package dev.zero.practiceexamgoesbruhh.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitInstance {
    // Trên emulator: 10.0.2.2 trỏ về host machine
    private const val BASE_URL = "http://10.0.2.2:3000/"

    val api: RecipeApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RecipeApiService::class.java)
    }
}