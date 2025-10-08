package com.example.deliciartsabores.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode.Companion.Clamp
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.deliciartsabores.R
import com.example.deliciartsabores.model.Produto

@Composable
fun ProductCard(
    produto: Produto,
    quantidade: Int,
    onIncrement: () -> Unit,
    onDecrement: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(vertical = 4.dp, horizontal = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(R.color.laranja_fraco)
        ),
        border = BorderStroke(
            width = 2.dp,
            color = colorResource(id = R.color.marrom)),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth().fillMaxHeight(), verticalAlignment = Alignment.CenterVertically) {


            Box(
                modifier = Modifier.weight(0.3f).fillMaxHeight()
            ) {

                Image(
                    painter = painterResource(id = produto.imageRes),
                    contentDescription = produto.title,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop

                )

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.horizontalGradient(
                                colors = listOf(
                                    Color.Transparent,
                                    colorResource(id = R.color.laranja_fraco)
                                ),
                                startX = 190f,
                                endX = 300f
                            )
                        )
                )
            }

            Row(
                modifier = Modifier
                    .weight(0.6f)
                    .fillMaxHeight()
                    .padding(horizontal = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

            Column(modifier = Modifier.padding(8.dp).weight(0.8f)) {
                Text(
                    text = produto.title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )

                Text(
                    text = "R$ ${produto.price}",
                    style = MaterialTheme.typography.titleSmall,
                    fontSize = 12.sp
                )

                Spacer(modifier = Modifier.width(8.dp))
            }

                if (quantidade == 0) {
                    Button(
                        onClick = onIncrement,
                        modifier = Modifier
                            .height(30.dp)
                            .width(60.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(R.color.marrom),
                            contentColor = Color.White
                        ),
                        shape = RoundedCornerShape(8.dp),
                        contentPadding = ButtonDefaults.ContentPadding
                    ) {
                        Text(
                            "+",
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.labelMedium
                        )
                    }
                } else {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(4.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.height(40.dp)
                    ) {
                        QuantityButton(
                            icon = "-",
                            onClick = onDecrement,
                            enabled = quantidade > 0
                        )

                        Text(
                            text = quantidade.toString(),
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.width(20.dp)
                        )

                        QuantityButton(
                            icon = "+",
                            onClick = onIncrement,
                            enabled = true
                        )
                    }
                }
            }
        }
    }
}


    @Composable
    fun QuantityButton(
        icon: String,
        onClick: () -> Unit,
        enabled: Boolean
    ) {
        Surface(
            shape = CircleShape,
            color = if (enabled) colorResource(R.color.marrom) else Color.LightGray,
            modifier = Modifier
                .size(32.dp)
                .clickable(onClick = onClick, enabled = enabled),
            shadowElevation = 2.dp
        ) {
            Box(contentAlignment = Alignment.Center) {
                Text(
                    text = icon,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
    }


@Composable
fun SizeChip(label: String) {
    Surface(
        shape = CircleShape,
        color = Color(0xFFFFE0B2),
        modifier = Modifier.size(32.dp),
        border = BorderStroke(1.dp, Color.Gray)
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(text = label, fontWeight = FontWeight.Bold)
        }
    }
}
