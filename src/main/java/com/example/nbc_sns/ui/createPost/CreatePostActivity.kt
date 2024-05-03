package com.example.nbc_sns.ui.createPost

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.nbc_sns.R
import com.example.nbc_sns.databinding.ActivityCreatePostBinding
import com.example.nbc_sns.model.PostImages
import com.example.nbc_sns.model.SelectedImage
import com.example.nbc_sns.ui.PostManager
import com.example.nbc_sns.ui.profile.ProfileActivity
import com.example.nbc_sns.ui.profile.ProfileActivity.Companion.BUNDLE_KEY_FOR_CREATE_POST_CHECK

class CreatePostActivity : AppCompatActivity(), ImageLocationListener {

    private lateinit var binding: ActivityCreatePostBinding
    private lateinit var selectedImage: SelectedImage
    private lateinit var userId: String

    private val adapter by lazy {
        CreatePostAdapter()
    }

    override fun changedTo(position: Int) {
        updateImageIndex(position + 1)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreatePostBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setRecyclerView()
        if (processImageFromIntent().not()) {
            return
        }
        initView()
        setListener()
    }

    private fun setRecyclerView() {
        binding.rvSelectedImage.adapter = adapter
        SnapHelperOneByOne(this).attachToRecyclerView(binding.rvSelectedImage)
    }

    private fun processImageFromIntent(): Boolean {
        val selectedImage = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(BUNDLE_KEY_FOR_CREATE_POST_IMAGE, SelectedImage::class.java)
        } else {
            intent.getParcelableExtra(BUNDLE_KEY_FOR_CREATE_POST_IMAGE)
        } ?: run {
            Toast.makeText(
                baseContext,
                getString(R.string.no_image_passed_through_intent), Toast.LENGTH_LONG
            )
                .show()
            finish()
            return false
        }
        userId = intent.getStringExtra(BUNDLE_KEY_FOR_USER_ID) ?: run {
            Toast.makeText(baseContext, getString(R.string.no_user_id_passed_through_intent), Toast.LENGTH_LONG).show()
            finish()
            return false
        }
        this.selectedImage = selectedImage
        adapter.submitList(selectedImage.images)
        return true
    }

    private fun initView() {
        updateImageIndex(1)
    }

    private fun updateImageIndex(position: Int) {
        binding.textViewImageIndex.text = getString(R.string.current_index_from_all).format(
            position,
            selectedImage.images.size
        )
    }

    private fun setListener() {
        binding.btnSubmit.setOnClickListener {
            PostManager.addPost(binding.editTextContent.text.toString(), PostImages(selectedImage.images.map { it.uri }), userId)
            startActivity(Intent(this, ProfileActivity::class.java).apply {
                putExtra(BUNDLE_KEY_FOR_CREATE_POST_CHECK, true)
                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            })
        }
    }

    companion object {
        const val BUNDLE_KEY_FOR_CREATE_POST_IMAGE = "KEY_FOR_CREATE_POST_IMAGE"
        const val BUNDLE_KEY_FOR_USER_ID = "KEY_FOR_USER_ID"
    }
}