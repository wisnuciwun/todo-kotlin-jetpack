package com.example.simpletodo

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable

fun Card(selectedData : MutableState<Int>, openDialog: MutableState<Boolean>, id: Int, date: String, note: String, done: Int, deleteNote: (Int) -> Unit) {
    var iconLeft = Icons.Default.Create
    var color = Color.White

    if(done == 0){
        iconLeft = Icons.Default.Check
        color = Color.White
    }else{
        iconLeft = Icons.Default.Delete
        color = Color(0xFFA7F7A3)
    }

    Box(
        modifier = Modifier
            .background(color)
            .fillMaxWidth()
            .defaultMinSize(50.dp)
            .border(2.dp, Color.Black, RoundedCornerShape(6.dp)),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.80f),
            ) {
                Text(
                    modifier = Modifier
                        .padding(6.dp),
                    text = note
                )
                Text(
                    modifier = Modifier
                        .padding(6.dp),
                    text = date
                )
            }
            Row(modifier = Modifier
                .padding(0.dp, 0.dp, 10.dp, 0.dp)) {
                OutlinedButton(
                    modifier = Modifier
                        .size(30.dp),
                    shape = CircleShape,
                    contentPadding = PaddingValues(0.dp),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor =  Color.Gray),
                    onClick = {
                        openDialog.value = true
                        selectedData.value = id
                    }) {
                    Icon(
                        Icons.Default.Create,
                        contentDescription = "Click to update todo",
                        tint = Color.Gray
                    )
                }
                Spacer(modifier = Modifier.width(5.dp))
                OutlinedButton(
                    modifier = Modifier
                        .size(30.dp),
                    shape = CircleShape,
                    contentPadding = PaddingValues(0.dp),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor =  Color.Gray),
                    onClick = {
                        deleteNote(id)
                    }) {
                    Icon(
                        iconLeft,
                        contentDescription = "Click to delete todo",
                        tint = Color.Gray
                    )
                }
            }
        }
    }
}