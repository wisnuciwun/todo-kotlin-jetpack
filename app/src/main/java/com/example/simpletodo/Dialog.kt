package com.example.simpletodo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.SimpleDateFormat
import java.util.Date

@ExperimentalMaterial3Api
@Composable
fun Dialog(databaseOperation: DatabaseOperation, openDialog: MutableState<Boolean>, selectedId: MutableState<Int>, items : MutableList<Note>) {
    var updateNote by remember {
        mutableStateOf(TextFieldValue())
    }

    var enableButton = true

    if(updateNote.text == ""){
        enableButton = false
    }else{
        enableButton = true
    }

    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = { },
            confirmButton = { },
            title = {
                Text(
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    text = "Edit Todo"
                )
            },
            text = {
                Column(modifier = Modifier
                    .fillMaxWidth()) {
                    TextField(
                        value = updateNote,
                        onValueChange = { updateNote = it },
                    )
                    Spacer(Modifier.height(8.dp))
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                        ,
                        enabled = enableButton,
                        onClick = {
                            val newNote = Note(selectedId.value, SimpleDateFormat("dd/M/yyyy HH:MM").format(
                                Date()
                            ), updateNote.text)
                            databaseOperation.updateNote(newNote)
                            openDialog.value = false
                            items.set(items.indexOfFirst { it.id == selectedId.value }, newNote)
                        }) {
                        Text(
                            textAlign = TextAlign.Center,
                            fontSize = 20.sp,
                            text = "Update Todo"
                        )
                    }
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                        ,
                        onClick = {
                        openDialog.value = false
                    }) {
                        Text(
                            textAlign = TextAlign.Center,
                            fontSize = 20.sp,
                            text = "Dismiss"
                        )
                    }
                }
            },
        )

    }
}