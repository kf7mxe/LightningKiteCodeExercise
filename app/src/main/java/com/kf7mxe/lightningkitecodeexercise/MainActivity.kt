package com.kf7mxe.lightningkitecodeexercise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.google.gson.GsonBuilder
import com.kf7mxe.lightningkitecodeexercise.ViewModels.PostsViewModel
import com.kf7mxe.lightningkitecodeexercise.components.PostCard
import com.kf7mxe.lightningkitecodeexercise.models.Post
import com.kf7mxe.lightningkitecodeexercise.ui.theme.LightningKiteCodeExerciseTheme
import okhttp3.*
import java.io.IOException

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = PostsViewModel()

        viewModel.fetch("https://jsonplaceholder.typicode.com/posts")
        setContent {
            LightningKiteCodeExerciseTheme {
                
                Column( verticalArrangement = Arrangement.SpaceAround) {
                    Text(text = "Posts!",fontSize = 30.sp, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)

                    val list by viewModel.posts.observeAsState(initial = emptyList())
                    LazyColumn(modifier = Modifier){
                        items(list.toList()){ post ->
                            PostCard(post = post)
                        }
                    }
                }
                


            }
        }
    }
}





