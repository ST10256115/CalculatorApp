package vcmsa.projects.prog7313g2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        // Get the result from the intent
        val result = intent.getDoubleExtra("RESULT_VALUE", 0.0)

        // Find the TextView and set the result
        val resultTextView = findViewById<TextView>(R.id.resultTextView)
        resultTextView.text = "Result: $result"
    }
}