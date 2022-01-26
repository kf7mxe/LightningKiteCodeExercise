package com.kf7mxe.lightningkitecodeexercise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
//        fetch("https://jsonplaceholder.typicode.com/posts")
        val viewModel = PostsViewModel()
        viewModel.fetch("https://jsonplaceholder.typicode.com/posts")
        setContent {
            LightningKiteCodeExerciseTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
                LazyColumn{
                    itemsIndexed(items = viewModel.posts){
                        index, item ->  PostCard(post = item)
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LightningKiteCodeExerciseTheme {
        Greeting("Android")
    }
}

