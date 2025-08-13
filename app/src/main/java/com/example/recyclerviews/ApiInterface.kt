package com.example.recyclerviews

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiInterface {
    @GET("/posts")
    fun getPosts(): Call <List<Post>>

    @GET("/post/{postId}")
    fun getPostById(@Path("postId")postId:Int): Call<Post>
}