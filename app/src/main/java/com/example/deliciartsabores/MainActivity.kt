package com.example.deliciartsabores

import android.graphics.Paint.Align
import android.graphics.drawable.shapes.Shape
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    val scrollState = rememberScrollState()
    val total = "R$ " + "300" + ",00"
    Column (
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
    ){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .background(colorResource(id = R.color.laranja)),
        contentAlignment = Alignment.Center,
        ){
        Text(
            text = "Deliciart Sabores",
            style = (MaterialTheme.typography.titleLarge),
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.white)
        )
        }
        Spacer(modifier = Modifier.padding(20.dp))
        Text(
            text = "Novo pedido",
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
        )
        Spacer(modifier = Modifier.padding(8.dp))
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            CardOptions(item = "12 Empadas", valor = "R$ 24,00", modifier = Modifier.weight(1f))
            CardOptions(item = "6 Empadas", valor = "R$ 12,00", modifier = Modifier.weight(1f))
        }
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            CardOptions(item = "Bolo Vulcão", valor = "R$ 55,00", modifier = Modifier.weight(1f))
            CardOptions(item = "Bolo Vulcão", valor = "R$ 45,00", modifier = Modifier.weight(1f))
        }
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            CardOptions(item = "Empada", valor = "20,00 R$", modifier = Modifier.weight(1f))
            CardOptions(item = "Bolo", valor = "70,00 R$", modifier = Modifier.weight(1f))
        }



        Spacer(modifier = Modifier.padding(8.dp))
        Text(
            text = "Total: ${total}",
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
        )
        Button(
            modifier = Modifier.fillMaxWidth(0.8f),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.laranja)
            ),
            onClick = {}) {
            Text(text = "Finaliar pedido")

        }
    }
}

@Composable
fun CardOptions(modifier: Modifier = Modifier, item: String, valor: String){
        Card (
            modifier = modifier
                .heightIn(min = 120.dp)
                .fillMaxWidth()
                .padding(8.dp)
                .clickable { },
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
            colors = CardDefaults.cardColors(
                colorResource(id = R.color.marrom_fraco)
            )
        ) {
            Box (
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center,
            )
            {
                Column (
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                Text(text =  item, style = MaterialTheme.typography.bodyLarge)
                Text(text = valor, style = MaterialTheme.typography.bodyMedium)
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