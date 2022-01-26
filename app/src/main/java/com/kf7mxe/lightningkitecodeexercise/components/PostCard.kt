package com.kf7mxe.lightningkitecodeexercise.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kf7mxe.lightningkitecodeexercise.models.Post

@Composable
fun PostCard (post: Post){
    Card(shape = MaterialTheme.shapes.medium, modifier = Modifier.fillMaxSize()
        .padding(5.dp),elevation = 2.dp)
    {
        Column() {
            Text(text = post.title, fontWeight = FontWeight.Bold, modifier = Modifier.padding(5.dp))
            Text(text = post.body,modifier = Modifier.padding(5.dp))
        }
    }
}
