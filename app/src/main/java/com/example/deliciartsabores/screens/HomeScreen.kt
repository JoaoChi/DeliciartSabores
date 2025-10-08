package com.example.deliciartsabores.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.deliciartsabores.R
import com.example.deliciartsabores.components.AppToolBar
import com.example.deliciartsabores.ui.theme.DeliciartSaboresTheme

@Composable
fun HomeScreen(onNavigateToPedido: () -> Unit) {

    Scaffold(
        topBar = {
            AppToolBar(
                title = "Inicio",
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.padding(4.dp))
            Text(
                text = "Bem-vindo à Deliciart Sabores!",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )
            Text(
                text = "Selecione a opção desejada:",
                style = MaterialTheme.typography.headlineSmall,
                fontSize = 18.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            Button(
                modifier = Modifier
                    .fillMaxWidth(fraction = 0.95f)
                    .height(85.dp)
                    .padding(6.dp),
                onClick = { onNavigateToPedido() },
                shape = MaterialTheme.shapes.medium,
                border = BorderStroke(
                    width = 2.dp,
                    color = colorResource(id = R.color.marrom)),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.laranja_fraco)
                )
            ) {
                Text(text = "Cadastro de pedidos", fontSize = 20.sp, color = colorResource(R.color.marrom))
            }
            Button(
                modifier = Modifier
                    .fillMaxWidth(fraction = 0.95f)
                    .height(85.dp)
                    .padding(6.dp),
                onClick = { onNavigateToPedido() },
                shape = MaterialTheme.shapes.medium,
                border = BorderStroke(
                    width = 2.dp,
                    color = colorResource(id = R.color.marrom)),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.laranja)
                )
            ) {
                Text(text = "Cadastro de clientes", fontSize = 20.sp)
            }
            Button(
                modifier = Modifier
                    .fillMaxWidth(fraction = 0.95f)
                    .height(85.dp)
                    .padding(6.dp),
                onClick = { onNavigateToPedido() },
                shape = MaterialTheme.shapes.medium,
                border = BorderStroke(
                    width = 2.dp,
                    color = colorResource(id = R.color.marrom)),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.laranja_fraco)
                )
            ) {
                Text(text = "Cadastro de produtos", fontSize = 20.sp, color = colorResource(R.color.marrom))
            }
            Button(
                modifier = Modifier
                    .fillMaxWidth(fraction = 0.95f)
                    .height(85.dp)
                    .padding(6.dp),
                onClick = { onNavigateToPedido() },
                shape = MaterialTheme.shapes.medium,
                border = BorderStroke(
                    width = 2.dp,
                    color = colorResource(id = R.color.marrom)),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.laranja)
                )
            ) {
                Text(text = "Lista de pedidos", fontSize = 20.sp)
            }
            Button(
                modifier = Modifier
                    .fillMaxWidth(fraction = 0.95f)
                    .height(85.dp)
                    .padding(6.dp),
                onClick = { onNavigateToPedido() },
                shape = MaterialTheme.shapes.medium,
                border = BorderStroke(
                    width = 2.dp,
                    color = colorResource(id = R.color.marrom)),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.laranja_fraco)
                )
            ) {
                Text(text = "Histórico de pedidos", fontSize = 20.sp, color = colorResource(R.color.marrom))
            }

        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    DeliciartSaboresTheme {
        HomeScreen(
            onNavigateToPedido = { }
        )
    }
}