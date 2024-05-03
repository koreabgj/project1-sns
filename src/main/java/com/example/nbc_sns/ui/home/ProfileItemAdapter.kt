package com.example.nbc_sns.ui.home

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nbc_sns.databinding.RecyclerviewProfileItemBinding
import com.example.nbc_sns.model.UserInfo
import com.example.nbc_sns.ui.UserManager
import com.example.nbc_sns.ui.profile.ProfileActivity

class ProfileItemAdapter(private val items: MutableList<UserInfo>) : RecyclerView.Adapter<ProfileItemAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = RecyclerviewProfileItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class Holder(val binding: RecyclerviewProfileItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: UserInfo) {
            val userId = item.id
            val userInfo = UserManager.getUser(userId)

            binding.rvProfileItem.setImageURI(userInfo?.thumbnail)

            // 프로필 이미지 클릭 이벤트
            binding.rvProfileItem.setOnClickListener {
                val context = binding.root.context

                val intent = Intent(context, ProfileActivity::class.java)
                intent.putExtra(ProfileActivity.BUNDLE_KEY_FOR_USER_ID_CHECK, userId)
                context.startActivity(intent)
            }
        }

    }
}