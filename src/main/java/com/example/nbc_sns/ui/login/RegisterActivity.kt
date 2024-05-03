package com.example.nbc_sns.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.nbc_sns.R
import com.example.nbc_sns.databinding.ActivityRegisterBinding
import com.example.nbc_sns.model.UserInfo
import com.example.nbc_sns.ui.UserManager

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            val intent = Intent(this, LogInActivity::class.java)
            startActivity(intent)
        }

        binding.btnRegister.setOnClickListener {
            val name = binding.etName.text.toString()
            val id = binding.etEmail.text.toString()
            val pw = binding.etPw.text.toString()
            val rePw = binding.etRePw.text.toString()

            val emailPattern = Regex("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")
            val isEmailValid = emailPattern.matches(id)
            val isPasswordValid = pw.length >= 8

            when {
                listOf(name, id, pw, rePw).any { it.isBlank() } -> Toast.makeText(
                    this,
                    "입력되지 않은 정보가 있습니다",
                    Toast.LENGTH_SHORT
                ).show()

                !isEmailValid -> Toast.makeText(this, "유효한 이메일을 입력해 주세요", Toast.LENGTH_SHORT).show()

                !isPasswordValid -> Toast.makeText(this, "비밀번호는 8자 이상이어야 합니다", Toast.LENGTH_SHORT)
                    .show()

                pw != rePw -> Toast.makeText(this, "비밀번호가 일치하지 않습니다", Toast.LENGTH_SHORT).show()

                else -> {
                    val userInfo = UserInfo(id, pw, name, null, "")
                    val registerSuccess = UserManager.register(userInfo)

                    if (registerSuccess) {
                        Toast.makeText(this, "회원가입이 완료되었습니다", Toast.LENGTH_SHORT).show()
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                        finish()

                    } else {
                        Toast.makeText(this, "이미 존재하는 사용자입니다", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}