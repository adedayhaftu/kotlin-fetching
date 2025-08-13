package com.example.recyclerviews

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class PostRvAdapter(val context: Context, var posts:List<Post>): RecyclerView.Adapter<PostViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PostViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.post_list_item, parent, false)
        return PostViewHolder(itemView)

    }

    override fun onBindViewHolder(
        holder: PostViewHolder,
        position: Int
    ) {
        val currentPost = posts[position]
        holder.tvTitle.text = currentPost.title
        holder.tvBody.text = currentPost.body
        holder.tvUserId.text = currentPost.userid
            .toString()
        holder.cvPost.setOnClickListener {
            val intent = Intent(context, Viewpostactivity::class.java)
            intent.putExtra("POST_ID", currentPost.id)
            context.startActivity(intent)
        }
    }
    override fun getItemCount(): Int {
        return posts.size
    }
}
class PostViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    val tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)
    val tvBody = itemView.findViewById<TextView>(R.id.tvPostBody)
    val tvUserId = itemView.findViewById<TextView>(R.id.tvUserID)
    val cvPost =  itemView.findViewById<CardView>(R.id.cvPost)
}











