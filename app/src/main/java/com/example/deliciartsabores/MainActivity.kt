package com.example.deliciartsabores

import android.annotation.SuppressLint
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
fun CardOptions(
    modifier: Modifier = Modifier,
    item: String,
    valor: String,
    quantidade: Int,
    onQuantidadeChange: (Int) -> Unit
){


    val borderModifier = if (quantidade > 0){
        Modifier.border(2.dp, colorResource(R.color.laranja), RoundedCornerShape(8.dp))
    } else {
        Modifier
    }
    Card (
        modifier = modifier
            .heightIn(min = 120.dp)
            .fillMaxWidth()
            .padding(8.dp)
            .then(borderModifier)
            .clickable { onQuantidadeChange(quantidade + 1) },
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(
            colorResource(id = R.color.marrom_fraco)
        )
    ) {
        Box (
            modifier = Modifier
                .padding(6.dp)
                .fillMaxWidth(),
            contentAlignment = Alignment.TopEnd,
        ) {
            if ( quantidade > 0 ){
                Text(
                    text = "X",
                    color = colorResource(id = R.color.black),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .clickable {
                            onQuantidadeChange(quantidade - 1)
                        }

                )
            }
        }

        Column (
            modifier = Modifier
                .padding(12.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text =  item, style = MaterialTheme.typography.bodyLarge)
            Text(text = valor, style = MaterialTheme.typography.bodyMedium)

            if (quantidade > 0) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Quantidade: $quantidade",
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black

                )
            }
        }
    }
}

data class ItemPedido(
    val nome: String,
    val preco: Double
)

@Composable
fun App(modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()

    val itens = listOf(
        ItemPedido("12 Empadas", 24.0),
        ItemPedido("6 Empadas", 12.0),
        ItemPedido("Bolo Vulcão", 55.0),
        ItemPedido("Bolo Vulcão", 45.0),
        ItemPedido("Mini pizza", 3.0),
        ItemPedido("Assado", 2.0)
    )

    var quantidades by remember {
        mutableStateOf(List(itens.size) { 0 })
    }

    val total = itens.indices.sumOf { i -> itens[i].preco * quantidades[i] }


    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .background(colorResource(id = R.color.laranja)),
            contentAlignment = Alignment.Center,
        ) {
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
        itens.chunked(2).forEachIndexed { rowIndex, rowItens ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                rowItens.forEachIndexed { colIndex, item ->
                    val index = rowIndex * 2 + colIndex
                    CardOptions(
                        item = item.nome,
                        valor = "R$ %.2f".format(item.preco),
                        quantidade = quantidades[index],
                        onQuantidadeChange = { novaQtd ->
                            quantidades = quantidades.toMutableList().also {
                                it[index] = novaQtd
                            }
                        },
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }

                    Spacer(modifier = Modifier.padding(8.dp))
                    Text(
                        text = "Total: R$ %.2f".format(total),
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




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DeliciartSaboresTheme {
        App()
    }
}