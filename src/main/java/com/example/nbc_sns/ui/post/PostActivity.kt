package com.example.nbc_sns.ui.post

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.nbc_sns.databinding.ActivityPostBinding
import com.example.nbc_sns.ui.PostManager
import com.example.nbc_sns.ui.UserManager
import com.example.nbc_sns.ui.profile.ProfileActivity

class PostActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPostBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPostBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // user id, post id 가져오기
        val userId = intent.getStringExtra(BUNDLE_KEY_FOR_USER_ID_CHECK) ?: "newjeans@gmail.com"
        val postId = intent.getIntExtra(BUNDLE_KEY_FOR_POST_ID_CHECK, 0)

        // 1. userId를 이용해서 UserManager에서 userInfo를 가져오기
        val userInfo = UserManager.getUser(userId)!! // userId에 해당하는 UserInfo가 있다고 가정

        // 2. 가져 온 userInfo를 이용해서 thumbnail 적용하기
        binding.ivThumbnail.setImageURI(userInfo.thumbnail)
        binding.ivEnlargementThumbnail.setImageURI(userInfo.thumbnail)

        // 3. NickName 적용
        binding.tvNickName.text = userInfo.nickName

        // 4. postId를 이용해서 PostManager에서 Post 가져오기
        val post = PostManager.getSpecificPost(userId, postId)!! // postId에 해당하는 Post가 있다고 가정

        // 5. PostImage 적용
        val firstImageUri = post.postImages.uris.first()
        binding.ivPostImage.setImageURI(firstImageUri)
        binding.ivEnlargementPostImage.setImageURI(firstImageUri)

        // 6. PostContents 적용
        binding.tvPostContent.text = post.postContent

        // 뒤로가기 버튼 클릭 시 종료
        binding.btnPrev.setOnClickListener {
            finish()
        }

        // 썸네일 클릭 시 이미지 확대
        binding.ivThumbnail.setOnClickListener {
            binding.ivEnlargementThumbnail.visibility = View.VISIBLE
        }

        // 썸네일 확대 이미지 클릭 시 닫기
        binding.ivEnlargementThumbnail.setOnClickListener {
            binding.ivEnlargementThumbnail.visibility = View.GONE
        }

        // 닉네임 클릭 시 디테일 화면으로 이동
        binding.tvNickName.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            intent.putExtra(ProfileActivity.BUNDLE_KEY_FOR_USER_ID_CHECK, userId)
            startActivity(intent)
        }

        // 포스트이미지 클릭 시 이미지 확대
        binding.ivPostImage.setOnClickListener {
            binding.ivEnlargementPostImage.visibility = View.VISIBLE
        }

        // 포스트이미지 확대 이미지 클릭 시 닫기
        binding.ivEnlargementPostImage.setOnClickListener {
            binding.ivEnlargementPostImage.visibility = View.GONE
        }
    }

    companion object {
        const val BUNDLE_KEY_FOR_POST_ID_CHECK = "KEY_FOR_POST_ID_CHECK"
        const val BUNDLE_KEY_FOR_USER_ID_CHECK = "KEY_FOR_USER_ID_CHECK"
    }
}