package com.example.semana2_2_

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.semana2_2_.ui.theme.Semana2_2_Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            principal()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun appBar() {
    TopAppBar(
        title = { Text(text = "UPC - Ejercicio 2") },
        backgroundColor = Color.Blue,
        contentColor = Color.White
    )
}

@Preview(showBackground = true)
@Composable
fun principal() {

    var txtProducto by remember{mutableStateOf("")}
    var txtPrecio by remember{mutableStateOf("")}
    var txtCantidad by remember{mutableStateOf("")}
    var Subtotal by remember{mutableStateOf("0.0")}
    var Igv by remember{mutableStateOf("0.0")}
    var Total by remember{mutableStateOf("0.0")}

    Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally)
    {
        appBar()
        Text(text = "Venta de productos", fontSize = 30.sp,
            color=Color.Blue, textAlign = TextAlign.Center)

        OutlinedTextField(value = txtProducto,
            modifier = Modifier.padding(5.dp),
            label = { Text(text = "Ingrese Producto")},
            onValueChange = {
                txtProducto=it
            })

        OutlinedTextField(value = txtPrecio,
            modifier = Modifier.padding(5.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = { Text(text = "Ingrese Precio")},
            onValueChange = {
                txtPrecio=it
            })

        OutlinedTextField(value = txtCantidad,
            modifier = Modifier.padding(5.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = { Text(text = "Ingrese Cantidad")},
            onValueChange = {
                txtCantidad=it
            })

        Button(
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue),
            modifier = Modifier
                .padding(20.dp)
                .width(250.dp),
            onClick = {


            }) {
            Text(text = "Calcular Venta",color=Color.White)
        }

        Text(text = "Subtotal: ", fontSize = 20.sp,
            color=Color.Blue, textAlign = TextAlign.Center)

        Text(text = "Igv 18%", fontSize = 20.sp,
            color=Color.Blue, textAlign = TextAlign.Center)

        Text(text = "Total: ", fontSize = 20.sp,
            color=Color.Blue, textAlign = TextAlign.Center)

    }

}