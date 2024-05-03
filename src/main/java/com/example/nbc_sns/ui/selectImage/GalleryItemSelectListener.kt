package com.example.nbc_sns.ui.selectImage

interface GalleryItemSelectListener {

    fun update(selectedItems: List<GalleryItem>)
    fun exceedPossibleCount()
}