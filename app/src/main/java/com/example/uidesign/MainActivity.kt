package com.example.uidesign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var presenter: LoginContract.Presenter
    private lateinit var user: EditText
    private lateinit var password: EditText
    private lateinit var signin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        user = findViewById<EditText>(R.id.edit_username)
        password = findViewById<EditText>(R.id.edit_password)
        val forgetPassword = findViewById<TextView>(R.id.forget_password)
        val signup = findViewById<TextView>(R.id.signuptext)
         signin = findViewById<Button>(R.id.signinbtn)



        // Create the presenter
        presenter = LoginPresenter(this)

signin.setOnClickListener {
    val username = user.text.toString()
    val password = password.text.toString()
    presenter.login(username, password)
}



forgetPassword.setOnClickListener {

    Toast.makeText(this@MainActivity,"Navigation to forgetpassword",Toast.LENGTH_SHORT).show()
}
        signup.setOnClickListener {

            Toast.makeText(this@MainActivity,"Navigation to signup",Toast.LENGTH_SHORT).show()
        }

    }
    // Implement LoginContract.View methods
    fun showValidationError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    fun showLoginSuccess(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        // Navigate to the next screen or perform necessary actions on successful login
    }

    fun showLoginError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

     fun navigateToHomePage() {
        val intent = Intent(this, bottomNavigation::class.java)
        startActivity(intent)
        finish()
    }
}