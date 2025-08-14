package com.example.recycler_view

import kotlin.toString



import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class PostRVAdapter(val context: Context,val posts: List<Post>): RecyclerView.Adapter<PostsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.post_list_item,parent,false)
        return PostsViewHolder(itemView)
    }
    override fun getItemCount(): Int {
        return posts.size
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        val currentPost= posts[position]
        holder.tvTitle.text=currentPost.title
        holder.tvBody.text=currentPost.body
        holder.tvUserId.text=currentPost.userId.toString()
        holder.cvPost.setOnClickListener { val intent= Intent(context, ViewPostActivity::class.java)
            intent.putExtra("POST_ID",currentPost.id)
            //allow to add smll pieces of data like double and those kind of things
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }
    }

}

class PostsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    val tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)
    val tvBody= itemView.findViewById<TextView>(R.id.tvBody)
    val tvUserId= itemView.findViewById<TextView>(R.id.tvUserId)
    val cvPost=itemView.findViewById<CardView>(R.id.cvPost)
}