package com.example.listadetareasapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionFactory
import com.airbnb.lottie.compose.rememberLottieComposition
import com.airbnb.lottie.compose.rememberLottieAnimationState
import com.example.listadetareasapp.ui.theme.ListaDeTareasAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListaDeTareasAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { padding ->
                    MainScreen(modifier = Modifier.padding(padding))
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    // Cargar la animación Lottie desde el archivo raw
    val composition by rememberLottieComposition(
        LottieCompositionFactory.fromRawFile(context = LocalContext.current, resId = R.raw.astronauta)  // Asegúrate de usar astronauta.json
    )
    val animationState = rememberLottieAnimationState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Animación de Lottie
        LottieAnimation(
            composition = composition,
            animationState = animationState,
            modifier = Modifier.size(150.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Título de la pantalla
        Text(text = "¡Bienvenido!", style = androidx.compose.ui.text.TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold))
        Spacer(modifier = Modifier.height(10.dp))

        // Campo de texto (correo)
        TextField(
            value = "",
            onValueChange = {},
            label = { Text("Correo") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(10.dp))

        // Campo de texto (contraseña)
        TextField(
            value = "",
            onValueChange = {},
            label = { Text("Contraseña") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(10.dp))

        // Botón para iniciar sesión
        Button(onClick = { /* Acción al presionar el botón */ }) {
            Text(text = "Ingresar")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    ListaDeTareasAppTheme {
        MainScreen()
    }
}
