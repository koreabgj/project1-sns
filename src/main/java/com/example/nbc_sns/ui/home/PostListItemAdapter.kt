package com.example.nbc_sns.ui.home

import android.content.Intent
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nbc_sns.databinding.RecyclerviewPostListItemBinding
import com.example.nbc_sns.model.Post
import com.example.nbc_sns.ui.UserManager
import com.example.nbc_sns.ui.profile.ProfileActivity
import com.example.nbc_sns.ui.profile.ProfileActivity.Companion.BUNDLE_KEY_FOR_USER_ID_CHECK

class PostListItemAdapter(
    private val items: MutableList<Post>,
    private val imageClickListener: ImageClickListener,
) : RecyclerView.Adapter<PostListItemAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = RecyclerviewPostListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class Holder(val binding: RecyclerviewPostListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Post) {
            val userId = item.authorId
            val userInfo = UserManager.getUser(userId)
            var isClickEvent = false

            binding.ivProfileItem.setImageURI(userInfo?.thumbnail)
            binding.tvNickname.text = UserManager.getUserNickName(item.authorId)
            val imageUri = item.postImages.uris.first()
            binding.ivPostImage.setImageURI(imageUri) // 이미지 첫번째것 나옴
            binding.tvPostContent.text = item.postContent
            binding.tvPostContent.maxLines = 2 // ViewHolder가 재사용될 때마다, 이전에 더보기를 누른 것이 초기화(더보기를 누르지 않은 상태로)된다.
            binding.tvPostContent.ellipsize = TextUtils.TruncateAt.END

            // 더 보기 클릭 이벤트
            binding.btnSeeMore.setOnClickListener {
                isClickEvent = !isClickEvent

                if (isClickEvent) {
                    binding.btnSeeMore.text = "숨기기"
                    binding.tvPostContent.ellipsize = null
                    binding.tvPostContent.maxLines = 100
                } else {
                    binding.btnSeeMore.text = "더 보기"
                    binding.tvPostContent.ellipsize = TextUtils.TruncateAt.END
                    binding.tvPostContent.maxLines = 2
                }
            }

            // 게시글 유저 프로필 클릭 이벤트
            binding.ivProfileItem.setOnClickListener {
                imageClickListener.click(userInfo?.thumbnail!!)
            }

            // 게시글 유저 포스트 이미지 클릭 이벤트
            binding.ivPostImage.setOnClickListener {
                imageClickListener.click(imageUri)
            }

            // 게시글 유저 아이디 클릭 이벤트
            binding.tvNickname.setOnClickListener {
                val context = binding.root.context

                val intent = Intent(context, ProfileActivity::class.java)
                intent.putExtra(BUNDLE_KEY_FOR_USER_ID_CHECK, userId)
                context.startActivity(intent)
            }
        }

    }
}