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
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@ExperimentalMaterial3Api
@Composable
fun Footer() {
    var notes by remember {
        mutableStateOf(TextFieldValue())
    }

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
                singleLine = true,
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
                onClick = { /*TODO*/ }) {
                Text(
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    text = "+"
                )

            }
        }

    }
}