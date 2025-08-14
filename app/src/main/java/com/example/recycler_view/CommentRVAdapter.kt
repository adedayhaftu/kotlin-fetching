package com.example.recycler_view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CommentRvAdapter(private val comments: List<Comment>) :
    RecyclerView.Adapter<CommentRvAdapter.CommentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.comment_list_item, parent, false)
        return CommentViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        val currentComment = comments[position]
        holder.tvCommentName.text = currentComment.name
        holder.tvCommentEmail.text = currentComment.email
        holder.tvCommentBody.text = currentComment.body
    }

    override fun getItemCount() = comments.size

    class CommentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvCommentName: TextView = itemView.findViewById(R.id.tvCommentName)
        val tvCommentEmail: TextView = itemView.findViewById(R.id.tvCommentEmail)
        val tvCommentBody: TextView = itemView.findViewById(R.id.tvCommentBody)
    }
}