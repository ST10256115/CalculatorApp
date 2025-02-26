package vcmsa.projects.prog7313g2

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth



class RegisterActivity : AppCompatActivity() {

    private lateinit var etEmail: EditText
    private lateinit var etDOB: EditText
    private lateinit var etPassword: EditText
    private lateinit var etConfirmPassword: EditText
    private lateinit var btnRegister: Button
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance()

        // Initialize UI elements
        etEmail = findViewById(R.id.etEmail)
        etDOB = findViewById(R.id.etDOB)
        etPassword = findViewById(R.id.etPassword)
        etConfirmPassword = findViewById(R.id.etConfirmPassword)
        btnRegister = findViewById(R.id.btnRegister)

        // Register Button Click Listener
        btnRegister.setOnClickListener {
            registerUser()
        }
    }

    private fun registerUser() {
        val email = etEmail.text.toString().trim()
        val password = etPassword.text.toString().trim()
        val confirmPassword = etConfirmPassword.text.toString().trim()

        // Validate input
        when {
            TextUtils.isEmpty(email) -> {
                etEmail.error = "Email is required"
                return
            }
            TextUtils.isEmpty(password) -> {
                etPassword.error = "Password is required"
                return
            }
            password.length < 6 -> {
                etPassword.error = "Password must be at least 6 characters"
                return
            }
            password != confirmPassword -> {
                etConfirmPassword.error = "Passwords do not match"
                return
            }
        }

        // Firebase registration
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "Registration Successful!", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, LoginActivity::class.java))
                    finish()
                } else {
                    Toast.makeText(this, "Registration Failed: ${task.exception?.message}", Toast.LENGTH_LONG).show()
                }
            }
    }
}