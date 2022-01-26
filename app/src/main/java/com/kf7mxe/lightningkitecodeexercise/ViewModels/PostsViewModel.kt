package com.kf7mxe.lightningkitecodeexercise.ViewModels

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.kf7mxe.lightningkitecodeexercise.models.Post
import okhttp3.*
import java.io.IOException

class PostsViewModel {
    val posts: List<Post> = ArrayList()

    fun fetch(url:String){
        val request = Request.Builder().url(url).build()
        val client = OkHttpClient()
        client.newCall(request).enqueue(object: Callback {
            override fun onResponse(call: Call, response: Response) {
                val body = response?.body?.string()
                val gson = Gson();
                val typeToken = object : TypeToken<List<Post>>() { }.type
                val posts = gson.fromJson<List<Post>>(body,typeToken)
            }

            override fun onFailure(call: Call, e: IOException) {
                TODO("Not yet implemented")
                println(e.localizedMessage)
            }
        })
    }

}