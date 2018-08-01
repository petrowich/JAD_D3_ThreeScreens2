package su.petrowich.jad_d3_threescreens2

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class BActivity : AppCompatActivity() {

    var textFromA: String? = null
    var textFromC: String? = null
    val requestCodeC: Int = 10101

    var startedC : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)
        title = "screen B"

        val extra = intent.extras
        val textViewB1 = findViewById<TextView>(R.id.textViewB1)

        textFromA = extra.getString("TextFromA")
        textViewB1.text = textFromA

        val buttonB = findViewById<Button>(R.id.buttonB)
        buttonB.setOnClickListener {
            val intent = Intent(applicationContext, CActivity::class.java).apply { putExtra("TextFromA", textFromA) }
            startedC = true
            startActivityForResult(intent, requestCodeC)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == requestCodeC) {

            val textViewB2 = findViewById<TextView>(R.id.textViewB2)
            textFromC = data?.getStringExtra("TextFromC")
            textViewB2.text = textFromC
        }
    }

    override fun finish() {
        val intent = Intent()
        intent.putExtra("TextFromC", textFromC)
        intent.putExtra("startedC", startedC)
        setResult(Activity.RESULT_OK, intent)

        super.finish()
    }
}
