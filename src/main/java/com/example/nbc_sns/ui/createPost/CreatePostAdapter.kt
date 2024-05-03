package com.example.nbc_sns.ui.createPost

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.nbc_sns.databinding.ItemSelectedImageAtCreatePostBinding
import com.example.nbc_sns.ui.selectImage.GalleryItem
import com.example.nbc_sns.util.GalleryItemDiffCallback

class CreatePostAdapter: ListAdapter<GalleryItem, CreatePostAdapter.ViewHolder>(GalleryItemDiffCallback()) {

    inner class ViewHolder(private val binding: ItemSelectedImageAtCreatePostBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(galleryItem: GalleryItem) {
            binding.imageViewThumbnail.setImageURI(galleryItem.uri)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemSelectedImageAtCreatePostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}