package com.example.nbc_sns.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.nbc_sns.R
import com.example.nbc_sns.databinding.ActivityLogInBinding
import com.example.nbc_sns.ui.UserManager
import com.example.nbc_sns.ui.home.MainActivity

class LogInActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLogInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val pw = binding.etPw.text.toString()
            val userInfo = UserManager.getUser(email)

            if (email.isBlank() || pw.isBlank()) {
                Toast.makeText(this, "아이디와 비밀번호를 확인해 주세요", Toast.LENGTH_SHORT).show()
                return@setOnClickListener

            } else if (pw.length < 8) {
                Toast.makeText(this, "비밀번호는 8자 이상이어야 합니다", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (userInfo != null && userInfo.pw == pw) {
                Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                UserManager.isLogin = true
                UserManager.loggedId = email
                startActivity(intent)

            } else {
                Toast.makeText(this, "회원정보를 찾을 수 없습니다", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }
    }
}