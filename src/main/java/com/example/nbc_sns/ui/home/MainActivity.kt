package com.example.nbc_sns.ui.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.nbc_sns.databinding.ActivityMainBinding
import com.example.nbc_sns.ui.PostManager
import com.example.nbc_sns.ui.UserManager
import com.example.nbc_sns.ui.login.LogInActivity
import com.example.nbc_sns.ui.profile.ProfileActivity
import com.example.nbc_sns.util.insertDummyData
import kotlin.random.Random

class MainActivity : AppCompatActivity(), ImageClickListener {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val random = Random(System.currentTimeMillis())

    override fun click(uri: Uri) {
        binding.ivLargeProfileItem.setImageURI(uri)
        binding.ivLargeProfileItem.visibility = View.VISIBLE
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        insertDummyData()
        val posts = PostManager.getAllPosts().toMutableList() // Post가 리스트형태라서 mutableList로
        posts.shuffle(random)
        UserManager.getUser(posts.first().authorId)?.thumbnail

        binding.rvPostArea.adapter = PostListItemAdapter(posts, this)

        val allUsers = UserManager.getAllUser().toMutableList()
        allUsers.shuffle(random)
        binding.rvProfileArea.adapter = ProfileItemAdapter(allUsers)

        binding.ivLargeProfileItem.setOnClickListener {
            binding.ivLargeProfileItem.visibility = View.GONE
        }
        onClickMyPage()
    }

    private fun onClickMyPage() {
        binding.ivMyPage.setOnClickListener{
            if (UserManager.isLogin) {
                val intent = Intent(this, ProfileActivity::class.java)
                val userId = UserManager.loggedId
                intent.putExtra(ProfileActivity.BUNDLE_KEY_FOR_USER_ID_CHECK, userId)
                startActivity(intent)
            } else {
                val intent = Intent(this, LogInActivity::class.java)
                startActivity(intent)
            }
        }
    }
}