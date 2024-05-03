package com.example.nbc_sns.ui.selectImage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.nbc_sns.R
import com.example.nbc_sns.databinding.ItemGalleryBinding

class GalleryAdapter(
    private val imageSelectListener: GalleryItemSelectListener
) : ListAdapter<GalleryItem, GalleryAdapter.GalleryViewHolder>(diffCallback) {

    private val selectedItems = linkedMapOf<Long, GalleryItem>()

    inner class GalleryViewHolder(private val binding: ItemGalleryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(galleryItem: GalleryItem) {
            // TODO : MainThread에서 처리하다보니 프레임 드랍 발생. Glide를 사용하거나,
            //  Coroutine을 이용해 IO 쓰레드에서 처리하도록 바꿔야 함
            binding.imageViewThumbnail.setImageURI(galleryItem.uri)

            if (galleryItem.id !in selectedItems) {
                binding.tvSelected.visibility = View.INVISIBLE
                binding.root.background = null
            } else {
                val index = selectedItems.keys.indexOf(galleryItem.id) + 1
                if (index != 0) {
                    binding.tvSelected.text = index.toString()
                }
                binding.tvSelected.visibility = View.VISIBLE
                binding.root.background = AppCompatResources.getDrawable(binding.root.context, R.drawable.selected_item_background)
            }

            binding.root.setOnClickListener {
                val index = selectedItems.keys.indexOf(galleryItem.id)
                if (index != -1) {
                    selectedItems.remove(galleryItem.id)
//                    notifyItemRangeChanged(index, selectedItems.size - index + 1) // 이렇게 하면 뒤에 생성된 ViewHolder는 업데이트 안 됨
                    // TODO : notifyDatSetChanged 대신, 순서상 뒤에 있는 ViewHolder만 업데이트하도록 해야 함.
                    //  또한 uri로 Image를 또 생성하는 작업을 하지 않도록 확인 필요
                    notifyDataSetChanged()
                } else {
                    if (selectedItems.size >= MAX_AVAILABLE_SELECTING_COUNT) {
                        imageSelectListener.exceedPossibleCount()
                        return@setOnClickListener
                    }
                    selectedItems[galleryItem.id] = galleryItem
                    notifyItemChanged(adapterPosition)
                }
                imageSelectListener.update(selectedItems.values.toList())
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        return GalleryViewHolder(
            ItemGalleryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        const val MAX_AVAILABLE_SELECTING_COUNT = 5

        private val diffCallback = object : DiffUtil.ItemCallback<GalleryItem>() {
            override fun areItemsTheSame(oldItem: GalleryItem, newItem: GalleryItem): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: GalleryItem, newItem: GalleryItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}
