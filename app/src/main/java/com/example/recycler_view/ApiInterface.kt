package com.example.recycler_view

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("posts")
    fun getPosts(): Call<List<Post>>
    @GET("/posts/{postId}")
    fun getPostById(@Path("postId") postId: Int): Call<Post>
    @GET("posts/{postId}/comments")
    fun getCommentsForPost(@Path("postId") postId: Int): Call<List<Comment>>
}
