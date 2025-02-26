package vcmsa.projects.prog7313g2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.widget.Button

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btnCalculator = findViewById<Button>(R.id.btnCalculator)
        val btnProfile = findViewById<Button>(R.id.btnProfile)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnCalculator.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        btnProfile.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }

        btnLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}