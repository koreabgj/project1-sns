package com.example.nbc_sns.ui

import android.net.Uri
import com.example.nbc_sns.model.UserInfo

object UserManager {

    private val users: HashMap<String, UserInfo> = hashMapOf() // Key: UserId , value: UserInfo

    var isLogin: Boolean = false
    var loggedId: String = ""

    fun getUser(userId: String): UserInfo? {
        return users[userId]
    }

    fun register(userInfo: UserInfo): Boolean {
        // 이미 존재하는 아이디와 겹치는지 검증
        if (userInfo.id in users) {
            return false // 가입 처리가 안 된 것
        }
        users[userInfo.id] = userInfo
        return true
    }

    // 존재하지 않는 회원에 대해 회원 탈퇴를 시도할 경우 false, 아니면  true를 반환함
    fun unregister(userId: String): Boolean {
        return users.remove(userId) != null
    }

    // 사용자의 프로필 사진을 업데이트합니다.
    fun updateUserThumbnail(userId: String, uri: Uri): Boolean {
        val userInfo = users[userId] ?: return false
        users[userId] = userInfo.copy(thumbnail = uri)
        return true
    }

    // 사용자 소개 문구를 업데이트합니다.
    fun updateUserIntroduction(userId: String, introduction: String): Boolean {
        val userInfo = users[userId] ?: return false
        users[userId] = userInfo.copy(introduction = introduction)
        return true
    }

    fun getAllUser(): List<UserInfo> {
        return users.values.toList()
    }

    fun getUserNickName(authorId: String): String {
        return users[authorId]?.nickName ?: "null"
    }
}