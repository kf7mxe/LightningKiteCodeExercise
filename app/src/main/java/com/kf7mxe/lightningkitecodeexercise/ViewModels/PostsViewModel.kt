package com.kf7mxe.lightningkitecodeexercise.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.kf7mxe.lightningkitecodeexercise.models.Post
import okhttp3.*
import java.io.IOException

class PostsViewModel {
    private val mPosts: MutableLiveData<List<Post>> = MutableLiveData()
    val posts: LiveData<List<Post>> get() = mPosts
//    fun addTestData(){
//        posts.value.add(Post(1,1,"test","stuff"))
//    }

    fun fetch(url:String){
        val request = Request.Builder().url(url).build()
        val client = OkHttpClient()
        client.newCall(request).enqueue(object: Callback {
            override fun onResponse(call: Call, response: Response) {
                val body = response?.body?.string()
                val gson = Gson();
                val typeToken = object : TypeToken<ArrayList<Post>>() { }.type
                mPosts.postValue(gson.fromJson<List<Post>>(body,typeToken))
            }

            override fun onFailure(call: Call, e: IOException) {
                TODO("Not yet implemented")
                println(e.localizedMessage)
            }
        })
    }
}