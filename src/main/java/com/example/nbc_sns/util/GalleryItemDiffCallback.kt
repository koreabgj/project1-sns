package com.example.nbc_sns.util

import androidx.recyclerview.widget.DiffUtil
import com.example.nbc_sns.ui.selectImage.GalleryItem

class GalleryItemDiffCallback: DiffUtil.ItemCallback<GalleryItem>() {
    override fun areItemsTheSame(oldItem: GalleryItem, newItem: GalleryItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: GalleryItem, newItem: GalleryItem): Boolean {
        return oldItem == newItem
    }
}