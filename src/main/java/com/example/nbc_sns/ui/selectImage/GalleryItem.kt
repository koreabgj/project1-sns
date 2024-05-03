package com.example.nbc_sns.ui.selectImage

import android.net.Uri
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.Date

@Parcelize
data class GalleryItem(
    val id: Long,
    val uri: Uri,
    val date: Date,
): Parcelable
