package com.example.gd3_c_0923

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    private lateinit var inputUsername: TextInputLayout
    private lateinit var inputPassword: TextInputLayout
    private lateinit var mainLayout: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //ubah title pada aplikasi
        setTitle("User Login")

        inputUsername = findViewById(R.id.inputLayoutUsername)
        inputPassword = findViewById(R.id.inputLayoutPassword)
        mainLayout = findViewById(R.id.mainLayout)
        val btnClear : Button = findViewById(R.id.btnClear)
        val btnLogin : Button = findViewById(R.id.btnLogin)

        //aksi btnClear
        btnClear.setOnClickListener{
            inputUsername.getEditText()?.setText("")
            inputPassword.getEditText()?.setText("")

            Snackbar.make(mainLayout, "Text Cleared Success", Snackbar.LENGTH_LONG).show()
        }
        //aksi pada btn login
        btnLogin.setOnClickListener(View.OnClickListener {
            var checkLogin = false
            val username: String = inputUsername.getEditText()?.getText().toString()
            val password: String = inputPassword.getEditText()?.getText().toString()

            //pengecekan apakah inputan kosong
            if (username.isEmpty()) {
                inputUsername.setError("Username Must be Filled With Text")
                checkLogin = false
            }
            //pengecekan apakah inputan kosong
            if (password.isEmpty()) {
                inputPassword.setError("Password Must be Filled With Text")
                checkLogin = false
            }

            if(username == "admin" && password == "0923") checkLogin = true

            if(!checkLogin)
                return@OnClickListener

            val moveHome = Intent ( this@MainActivity, HomeActivity::class.java)
            startActivity(moveHome)
        })
    }
}