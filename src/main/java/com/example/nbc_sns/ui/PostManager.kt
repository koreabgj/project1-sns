package com.example.nbc_sns.ui

import com.example.nbc_sns.model.Post
import com.example.nbc_sns.model.PostImages
object PostManager {

    private val posts: HashMap<String, List<Post>> = hashMapOf() // key: userId, value: Set<Post>
    private var postId = 0

    // 등록된 포스트 객체를 반환함
    fun addPost(content: String, postImages: PostImages, userId: String): Post {
        val currentPostId = postId++
        val createdPost = Post(currentPostId, userId, content, postImages, emptyList())
        posts[userId] = posts.getOrDefault(userId, listOf()) + createdPost
        return createdPost
    }

    // userId가 작성한 postId에 해당하는 포스트를 반환
    fun getSpecificPost(userId: String, postId: Int): Post? {
        val userPosts = posts[userId] ?: return null // 유저가 작성한 글만 선별하기
        for (post in userPosts) {
            if (post.postId == postId) { // 보여줘야 할 포스트만 선별하기
                return post
            }
        }
        return null
    }

    // 게시물이 전부 필요하면 호출
    fun getAllPosts(): List<Post> {
        return posts.values.fold(listOf()) { acc, posts ->
            acc + posts
        }
    }

    // 특정 유저가 가진 게시물 필요하면 호출
    fun getPost(userId: String): List<Post> {
        return posts[userId]?.toList() ?: emptyList()
    }
}