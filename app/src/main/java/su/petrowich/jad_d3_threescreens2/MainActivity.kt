package su.petrowich.jad_d3_threescreens2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    var editText : EditText? = null
    val requestCodeB: Int = 10100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "screen A"

        val buttonA = findViewById<Button>(R.id.buttonA)

        editText = findViewById(R.id.editTextA)

        buttonA.setOnClickListener {
            val intent = Intent(this, BActivity::class.java).apply { putExtra("TextFromA", editText?.text.toString()) }
            startActivityForResult(intent,requestCodeB)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        //определять, было ли открыто окно С по заполненному второму полю нельзя, т.к. в окне С могли всё стереть и вернуть пустое поле
        //поэтому отдельно сохраняем статус события открытия окна С

        val startedC : Boolean = data?.getBooleanExtra("startedC", false)!!

        if (requestCode == requestCodeB && startedC) {
            editText?.setText(data?.getStringExtra("TextFromC"))
        }
    }
}
