package com.example.simpletodo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.simpletodo.ui.theme.SimpleTodoTheme
import com.example.simpletodo.ui.theme.Typography

// this will appear ini emulator
@ExperimentalComposeUiApi
@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleTodoTheme {
                val context = LocalContext.current
                val dbOperation = DatabaseOperation(context)
                // give * is a must
                val items = remember { mutableStateListOf<Note>(*dbOperation.getNotes().toTypedArray()) }
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        Header()
                        Column(
                            modifier = Modifier
                                .fillMaxHeight(),
                            verticalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxHeight(0.9f)
                                    .padding(6.dp)
                                    .verticalScroll(rememberScrollState())
                            ){
                                for (item in items){
                                    Card(item.id, item.date, item.content) {
                                        itemId ->
                                        dbOperation.deleteNote(itemId)
                                        items.removeIf{it.id == itemId}
                                    }
                                    Spacer(modifier = Modifier
                                        .height(3.dp))
                                }
                            }
                            Footer(databaseOperation = dbOperation, items)
                        }
                    }
                }
            }
        }
    }
}

// this only show in preview not in emulator
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SimpleTodoTheme {}
}