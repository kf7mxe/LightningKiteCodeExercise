package com.kf7mxe.lightningkitecodeexercise.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.kf7mxe.lightningkitecodeexercise.models.Post

@Composable
fun PostCard (post: Post){
    Card(shape = MaterialTheme.shapes.small) {
        Column() {
            Text(text = post.title)
            Text(text = post.body)
        }
    }
}
