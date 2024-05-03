package com.example.nbc_sns.model

data class Post(
    val postId: Int, // 게시물을 구별하는 고유 번호
    val authorId: String, // 게시물 작성자 유저 번호
    val postContent: String, // 게시물 내용
    val postImages: PostImages, // 게시물 이미지
    val comments: List<Comment>, // 게시물에 달린 댓글
)
