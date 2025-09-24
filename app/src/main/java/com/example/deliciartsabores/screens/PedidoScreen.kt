package com.example.deliciartsabores.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.deliciartsabores.R
import com.example.deliciartsabores.components.AppToolBar
import com.example.deliciartsabores.components.ProductCard
import com.example.deliciartsabores.model.Produto
import com.example.deliciartsabores.ui.theme.DeliciartSaboresTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PedidoScreen(modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()

    val produtos = listOf(
        Produto(
            id = "1",
            imageRes = R.drawable.ic_launcher_foreground,
            title = "12 Empadas",
            price = 24.0

        ),
        Produto(
            id = "2",
            imageRes = R.drawable.ic_launcher_foreground,
            title = "6 Empadas",
            price = 12.0
        ),
//        Produto(
//            id = "3",
//            imageRes = R.drawable.ic_launcher_foreground,
//            title = "Bolo Vulcão Chocolate",
//            price = 55.0
//        ),
//        Produto(
//            id = "4",
//            imageRes = R.drawable.ic_launcher_foreground,
//            title = "Bolo Vulcão Cenoura",
//            price = 45.0
//        ),
//        Produto(
//            id = "5",
//            imageRes = R.drawable.ic_launcher_foreground,
//            title = "Mini Pizza",
//            price = 3.0
//        ),
//        Produto(
//            id = "6",
//            imageRes = R.drawable.ic_launcher_foreground,
//            title = "Assado",
//            price = 2.0
//        )
    )

    var quantidades by remember {
        mutableStateOf(List(produtos.size) { 0 })
    }
    val total = produtos.indices.sumOf { i -> produtos[i].price * quantidades[i] }


    Scaffold(
        topBar = {
            AppToolBar(
                title = "Realizar novo pedido",
                onBackClick = { }
            )
        }
    ) { padding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
        ) {
            produtos.chunked(2).forEachIndexed { rowIndex, rowItens ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    rowItens.forEachIndexed { colIndex, item ->
                        val index = rowIndex * 2 + colIndex
                        ProductCard(
                            produto = item,
                            onAddClick = {
                                quantidades = quantidades.toMutableList().also { list ->
                                    list[index] = list[index] + 1
                                }
                            }
                        )
                    }
                }
            }


            Spacer(modifier = Modifier.padding(2.dp))
            Text(
                text = "Total: R$ %.2f".format(total),
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
            )
            Spacer(modifier = Modifier.padding(8.dp))

//        TextField(
//            value = name,
//            onValueChange = { name = it },
//            label = { Text(text = "Nome") },
//            placeholder = { Text(text = "Nome do Cliente") },
//            leadingIcon = { Icon(Icons.Default.Create, contentDescription = null) },
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(16.dp)
//                .fillMaxWidth()
//                .border(
//                    width = 2.dp,
//                    color = colorResource(id = R.color.laranja),
//                ),
//            colors = TextFieldDefaults.colors(
//                focusedContainerColor = colorResource(id = R.color.marrom_fraco),
//                unfocusedContainerColor = colorResource(id = R.color.marrom_fraco),
//                disabledContainerColor = colorResource(id = R.color.marrom_fraco),
//                errorContainerColor = colorResource(id = R.color.marrom_fraco),
//                cursorColor = colorResource(id = R.color.laranja),
//                focusedIndicatorColor = Color.Transparent,
//                unfocusedIndicatorColor = Color.Transparent
//            )
//        )
//
//        TextField(
//            value = endereco,
//            onValueChange = { endereco = it },
//            label = { Text(text = "Endereço") },
//            placeholder = { Text(text = "Endereço do Cliente") },
//            leadingIcon = { Icon(Icons.Default.LocationOn, contentDescription = null) },
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(16.dp)
//                .fillMaxWidth()
//                .border(
//                    width = 2.dp,
//                    color = colorResource(id = R.color.laranja),
//                ),
//            colors = TextFieldDefaults.colors(
//                focusedContainerColor = colorResource(id = R.color.marrom_fraco),
//                unfocusedContainerColor = colorResource(id = R.color.marrom_fraco),
//                disabledContainerColor = colorResource(id = R.color.marrom_fraco),
//                errorContainerColor = colorResource(id = R.color.marrom_fraco),
//                cursorColor = colorResource(id = R.color.laranja),
//                focusedIndicatorColor = Color.Transparent,
//                unfocusedIndicatorColor = Color.Transparent
//            )
//        )


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp) // Espaço entre os botões
            ) {
                Button(
                    modifier = Modifier.weight(1f).height(60.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.laranja)
                    ),
                    onClick = { /* ação cliente existente */ }
                ) {
                    Text(text = "Selecionar cliente existente", textAlign = TextAlign.Center)
                }

                Button(
                    modifier = Modifier.weight(1f).height(60.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.laranja)
                    ),
                    onClick = { /* ação cadastrar cliente */ }
                ) {
                    Text(text = "Cadastrar novo cliente", textAlign = TextAlign.Center)
                }
            }

            Spacer(modifier = Modifier.padding(10.dp))

            Button(
                modifier = Modifier.fillMaxWidth(0.8f),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.laranja)
                ),
                onClick = {}) {
                Text(text = "Cadastrar pedido")

            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DeliciartSaboresTheme {
        PedidoScreen()
    }
}