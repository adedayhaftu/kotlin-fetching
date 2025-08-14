package com.example.recycler_view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostsActivity : AppCompatActivity() {
    lateinit var rvPost: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_post)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onResume() {
        super.onResume()
        rvPost = findViewById(R.id.rvPost)
        rvPost.layoutManager = LinearLayoutManager(this)
        fetchPosts()
        Toast.makeText(this,"A piece of toast", Toast.LENGTH_LONG).show()
    }

    fun fetchPosts() {
        val retrofit = ApiClient.buildApiClient(ApiInterface::class.java)
        val request = retrofit.getPosts()
        request.enqueue(object : Callback<List<Post>> {
            override fun onResponse(
                call: Call<List<Post>?>,
                response: Response<List<Post>?>
            ) {
                if (response.isSuccessful) {
//                    obtain ad display post
                    val posts = response.body()!!
                    val postAdapter = PostRVAdapter(baseContext,posts)

                    rvPost.adapter = postAdapter
                } else {
                    Toast.makeText(baseContext, response.errorBody()?.string(), Toast.LENGTH_LONG)
                        .show()
                }
            }

            override fun onFailure(
                call: Call<List<Post>?>,
                t: Throwable
            ) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }

        })
    }
}
//Global app context and activity context
//context tells the environment we are on
//the activity is dispalyed based on the activity u are living in
//global-created from the moment you create teh app until you leave it
//used to access resources so that you pass the context it knows where u at
//activity is used to access databases
//super class that tells where u currently are and tell you what is happening