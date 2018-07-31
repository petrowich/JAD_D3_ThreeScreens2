package su.petrowich.jad_d3_threescreens2

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class CActivity : AppCompatActivity() {

    var editTextC : EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c)
        title = "screen C"

        val extra = intent.extras

        editTextC = findViewById(R.id.editTextC)
        editTextC?.setText(extra.getString("TextFromA"))
    }

    override fun onStop() {
        super.onStop()
        val intent = Intent(this, BActivity::class.java).apply { putExtra("TextFromC", editTextC?.text.toString()) }
        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}
