package dev.zero.practiceexamgoesbruhh.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit
) {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    var code by remember { mutableStateOf("") }
    val correctCode = "PH52751"

    Scaffold(scaffoldState = scaffoldState) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            AsyncImage(
                model = "https://upload.wikimedia.org/wikipedia/commons/thumb/2/20/FPT_Polytechnic.png/1200px-FPT_Polytechnic.png",
                contentDescription = "Logo FPT",
                modifier = Modifier.size(120.dp)
            )
            Spacer(modifier = Modifier.height(24.dp))
            OutlinedTextField(
                value = code,
                onValueChange = { code = it },
                label = { Text("Nhập MSV") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    if (code == correctCode) {
                        onLoginSuccess()
                    } else {
                        scope.launch {
                            scaffoldState.snackbarHostState
                                .showSnackbar("Mã sinh viên không đúng")
                        }
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Tiếp tục")
            }
        }
    }
}