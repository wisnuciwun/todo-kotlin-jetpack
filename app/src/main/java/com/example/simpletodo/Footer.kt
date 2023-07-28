package com.example.simpletodo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ExperimentalComposeApi
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import java.text.SimpleDateFormat
import java.util.Date

@ExperimentalMaterial3Api
@ExperimentalComposeUiApi
@Composable
fun Footer(databaseOperation: DatabaseOperation, items: MutableList<Note>) {
    var notes by remember {
        mutableStateOf(TextFieldValue())
    }
    val keyboardController = LocalSoftwareKeyboardController.current
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Gray)
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = notes,
                onValueChange = { notes = it },
                label = { Text("Write your todo here") },
                keyboardActions = KeyboardActions(
                    onDone = {
                    keyboardController?.hide()
                }),
                maxLines = 3,
                singleLine = false,
                shape = RoundedCornerShape(6.dp),
                modifier = Modifier
                    .padding(0.dp, 0.dp, 8.dp, 0.dp)
                    .height(52.dp)
                    .weight(1f)
            )
            Button(
                modifier = Modifier
                    .height(52.dp),
                shape = RoundedCornerShape(6.dp),
                onClick = {
                    val newNote = Note(0, SimpleDateFormat("dd/M/yyyy").format(Date()), notes.text)
                    databaseOperation.insertNewNote(newNote)
                    notes = TextFieldValue()
                    items.add(newNote)
                }) {
                Text(
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    text = "+"
                )

            }
        }

    }
}