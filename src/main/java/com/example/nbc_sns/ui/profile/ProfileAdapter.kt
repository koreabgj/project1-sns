package com.example.nbc_sns.ui.profile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.nbc_sns.databinding.ItemImageAtProfileBinding
import com.example.nbc_sns.model.Post

class ProfileAdapter(
    private val postClickListener: PostClickListener,
) : ListAdapter<Post, ProfileAdapter.ViewHolder>(diffCallback) {

    inner class ViewHolder(private val binding: ItemImageAtProfileBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(post: Post) {
            binding.imageViewThumbnail.setImageURI(post.postImages.uris.first())
            binding.root.setOnClickListener {
                postClickListener.onClick(post.postId)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemImageAtProfileBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<Post>() {
            override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
                return oldItem.postId == newItem.postId
            }

            override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
                return oldItem == newItem
            }
        }
    }
}