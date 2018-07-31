package su.petrowich.jad_d3_threescreens2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "screen A"

        val buttonA = findViewById<Button>(R.id.buttonA)
        val editText = findViewById<EditText>(R.id.editTextA)

        buttonA.setOnClickListener {
            val intent = Intent(this, BActivity::class.java).apply { putExtra("TextFromA", editText.text.toString()) }
            startActivity(intent)
        }
    }
}
