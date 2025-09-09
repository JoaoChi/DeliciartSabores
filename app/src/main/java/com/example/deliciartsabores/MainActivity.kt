package com.example.deliciartsabores

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Card
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
        CardOptions(item = "Empada")
        CardOptions(item = "Bolo")
        CardOptions(item = "Cento")
        Button(
            onClick = {}) {
            Text(text = "Novo Pedido")

        }
    }
}

@Composable
fun CardOptions(modifier: Modifier = Modifier, item: String){

    Row (
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically,

    ) {
        Card (
            modifier = Modifier
                .weight(1f)
                .clickable { },
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
        ) {
            Box (
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            )
            {
                Text(text =  item, style = MaterialTheme.typography.bodyLarge)
            }

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