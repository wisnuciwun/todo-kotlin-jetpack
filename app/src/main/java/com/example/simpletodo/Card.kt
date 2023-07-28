package com.example.simpletodo

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
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

fun Card(id: Int, date: String, note: String, deleteNote: (Int) -> Unit) {
    Box(
        modifier = Modifier
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
                    .fillMaxWidth(0.85f),
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
                .padding(0.dp, 0.dp, 6.dp, 0.dp)) {
                IconButton(
                    modifier = Modifier
                        .background(Color.Gray)
                        .height(30.dp)
                        .width(30.dp)
                        .clip(CircleShape),
                    onClick = {

                    }) {
                    Icon(
                        Icons.Default.Check,
                        contentDescription = "Click to check todo",
                        tint = Color.White
                    )
                }
                IconButton(
                    modifier = Modifier
                        .background(Color.Gray)
                        .height(30.dp)
                        .width(30.dp)
                        .clip(CircleShape),
                    onClick = {
                        deleteNote(id)
                    }) {
                    Icon(
                        Icons.Default.Delete,
                        contentDescription = "Click to check todo",
                        tint = Color.White
                    )
                }
            }
        }
    }
}