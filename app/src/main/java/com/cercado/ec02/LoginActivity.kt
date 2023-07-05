package com.cercado.ec02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Patterns
import androidx.core.widget.addTextChangedListener
import com.cercado.ec02.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViews()

    }

    private fun setupViews() {
        binding.loginEmail.editText?.addTextChangedListener {text ->
            binding.loginButton.isEnabled = validateInputs(text.toString(), binding.loginPassword.editText?.text.toString())
        }
        binding.loginPassword.editText?.addTextChangedListener {text ->
            binding.loginButton.isEnabled = validateInputs( binding.loginEmail.editText?.text.toString(),text.toString())
        }

        binding.loginButton.setOnClickListener {

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()


        }
    }

    private fun validateInputs(email: String, password: String): Boolean{
        val isEmailOk = email.isNotEmpty() && email.equals("ejemplo@idat.edu.pe")
        val isPasswordOk = password.length == 6 && password.equals("123456")
        return isPasswordOk && isEmailOk
    }


}