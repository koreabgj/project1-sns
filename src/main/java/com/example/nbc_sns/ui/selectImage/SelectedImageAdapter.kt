package com.example.nbc_sns.ui.selectImage

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.nbc_sns.databinding.ItemSelectedImageBinding
import com.example.nbc_sns.util.GalleryItemDiffCallback

class SelectedImageAdapter: ListAdapter<GalleryItem, SelectedImageAdapter.ViewHolder>(GalleryItemDiffCallback()) {

    inner class ViewHolder(private val binding: ItemSelectedImageBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(galleryItem: GalleryItem) {
            binding.imageViewThumbnail.setImageURI(galleryItem.uri)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemSelectedImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}