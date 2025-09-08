package com.example.deliciartsabores

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.deliciartsabores.ui.theme.DeliciartSaboresTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DeliciartSaboresTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    App(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun App(modifier: Modifier = Modifier) {
    val message = ""
    Column (
        modifier = modifier
            .fillMaxSize()
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ){
        Text(
            text = "Deliciart Sabores",
            style = (MaterialTheme.typography.titleMedium),
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = "Realizar novo pedido",
            style = MaterialTheme.typography.bodyMedium
        )
        Button(
            onClick = {}) {
            Text(text = "Novo Pedido")

        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DeliciartSaboresTheme {
        App()
    }
}