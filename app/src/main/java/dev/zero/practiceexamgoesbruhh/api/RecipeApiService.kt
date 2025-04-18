package dev.zero.practiceexamgoesbruhh.api

import dev.zero.practiceexamgoesbruhh.model.Recipe
import retrofit2.http.GET

interface RecipeApiService {
    @GET("recipes")
    suspend fun getRecipes(): List<Recipe>
}