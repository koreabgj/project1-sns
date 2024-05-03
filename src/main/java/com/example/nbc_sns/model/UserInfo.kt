package com.example.nbc_sns.model

import android.net.Uri

// 사용자에 대한 정보를 나타내는 클래스
data class UserInfo(
    val id: String, // email 형식으로 입력받도록 regex로 사전에 확인 필요
    val pw: String, // 비밀번호
    val nickName: String, // 프로필 이미지 아래에 표시할 닉네임
    val thumbnail: Uri?, // 프로필에 표시할 이미지, null일 경우 기본 썸네일 표시
    val introduction: String, // 프로필에 표시할 소개 문구
)
