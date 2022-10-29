package com.example.myelec

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myelec.ui.theme.MyElecTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyElecTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
//                    Greeting("Android")
//                    Column(
//                        modifier = Modifier.fillMaxWidth(),
//                        horizontalAlignment = Alignment.CenterHorizontally,
//                        verticalArrangement = Arrangement.Top
//                    ) {
//                        Index(" Compteur de jour")
//                        Index(" Compteur de nuit")
//                        Index(" Compteur panneaux")
//                    }
                    Index()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyElecTheme {
        Greeting("Android")
    }
}

@Composable
fun Index(type: String) {
    var text by remember { mutableStateOf(TextFieldValue()) }
    Box(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
            .background(color = MaterialTheme.colors.primary),
        contentAlignment = Alignment.TopStart
    ) {
        Text(
            modifier = Modifier.padding(bottom = 8.dp),
            text = type,
            color = MaterialTheme.colors.onPrimary,
            style = MaterialTheme.typography.h5
        )
    }
    Box(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.BottomCenter
    ) {
        TextField(modifier = Modifier.padding(bottom = 2.dp),
            value = text,
            onValueChange = {
                text = it
            })
    }

}

@Composable
fun Index() {
    val indexValues = remember {
        mutableStateListOf("0", "0", "0")
    }
    val textFieldTitles=remember {
        listOf("Compteur de jour", "Compteur de nuit", "Panneaux")
    }
    val listState = rememberLazyListState()
    val focusManager = LocalFocusManager.current
    LazyColumn(
        state = listState,
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        itemsIndexed(indexValues) { i, _ ->
            OutlinedTextField(value=indexValues[i],
                modifier = Modifier.padding(top = 16.dp),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions(
                    onNext = {focusManager.moveFocus(FocusDirection.Down)}
                ),
                onValueChange = {
                    indexValues[i] = it
                },
                label = {
                    Text(textFieldTitles[i])
                })
        }
    }
}