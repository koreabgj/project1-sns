package com.example.nbc_sns.model

import android.os.Parcelable
import com.example.nbc_sns.ui.selectImage.GalleryItem
import kotlinx.parcelize.Parcelize

@Parcelize
data class SelectedImage (
    val images: List<GalleryItem>
): Parcelable