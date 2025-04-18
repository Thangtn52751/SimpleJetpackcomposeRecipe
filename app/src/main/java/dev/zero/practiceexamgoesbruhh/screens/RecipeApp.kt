package dev.zero.practiceexamgoesbruhh.screens


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import dev.zero.practiceexamgoesbruhh.api.RetrofitInstance
import dev.zero.practiceexamgoesbruhh.model.Recipe
import kotlinx.coroutines.launch
@Composable
fun RecipeApp() {
    val scaffoldState = rememberScaffoldState()
    var recipes by remember { mutableStateOf<List<Recipe>>(emptyList()) }
    var selectedRecipe by remember { mutableStateOf<Recipe?>(null) }
    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        try {
            recipes = RetrofitInstance.api.getRecipes()
        } catch (e: Exception) {
            scope.launch {
                scaffoldState.snackbarHostState.showSnackbar("Lỗi tải dữ liệu")
            }
        }
    }

    Scaffold(scaffoldState = scaffoldState) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            items(recipes) { recipe ->
                RecipeItem(
                    recipe = recipe,
                    onClick = { selectedRecipe = recipe }
                )
            }
        }

        selectedRecipe?.let { recipe ->
            RecipeDetailDialog(
                recipe = recipe,
                onDismiss = { selectedRecipe = null }
            )
        }
    }
}