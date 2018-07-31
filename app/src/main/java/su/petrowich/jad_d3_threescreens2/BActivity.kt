package su.petrowich.jad_d3_threescreens2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class BActivity : AppCompatActivity() {

    var textFromA: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)
        title = "screen B"

        val extra = intent.extras
        val textViewB1 = findViewById<TextView>(R.id.textViewB1)

        if (savedInstanceState != null) {
            textViewB1.text = savedInstanceState.getString("TextFromA")
            savedInstanceState.clear()
        } else {
            textFromA = extra.getString("TextFromA")
            textViewB1.text = textFromA
        }

        val buttonB = findViewById<Button>(R.id.buttonB)
        buttonB.setOnClickListener{
            val intent = Intent(applicationContext, CActivity::class.java).apply { putExtra("TextFromA", textFromA) }
            startActivity(intent)
        }

    }

    override fun onActivityReenter(resultCode: Int, data: Intent?) {
        super.onActivityReenter(resultCode, data)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        val textViewB2 = findViewById<TextView>(R.id.textViewB2)

        textViewB2.text = data?.getStringExtra("TextFromC")
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {

        savedInstanceState.putString("TextFromA", textFromA)

        super.onSaveInstanceState(savedInstanceState)
    }

}
