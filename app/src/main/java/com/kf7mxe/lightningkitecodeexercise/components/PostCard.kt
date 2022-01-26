package com.kf7mxe.lightningkitecodeexercise.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.kf7mxe.lightningkitecodeexercise.models.Post

@Composable
fun PostCard (post: Post){
    Card(shape = MaterialTheme.shapes.large) {
        Column() {
            Text(text = post.title)
            Text(text = post.body)
        }
    }
}
