package vcmsa.projects.prog7313g2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        val etNumber1 = findViewById<EditText>(R.id.etNumber1)
        val etNumber2 = findViewById<EditText>(R.id.etNumber2)
        val addButton = findViewById<Button>(R.id.button2)

        // Set button click listener
        addButton.setOnClickListener {
            val number1Text = etNumber1.text.toString()
            val number2Text = etNumber2.text.toString()

            // Validate input
            if (number1Text.isNotEmpty() && number2Text.isNotEmpty()) {
                val number1 = number1Text.toDoubleOrNull()
                val number2 = number2Text.toDoubleOrNull()

                if (number1 != null && number2 != null) {
                    val result = number1 + number2

                    // Start ResultActivity and pass the result
                    val intent = Intent(this, ResultActivity::class.java)
                    intent.putExtra("RESULT_VALUE", result)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show()
            }
        }
    }
}