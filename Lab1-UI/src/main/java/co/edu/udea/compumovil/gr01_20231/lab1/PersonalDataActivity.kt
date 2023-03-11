package co.edu.udea.compumovil.gr01_20231.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent

class PersonalDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_data)

        val next = findViewById<Button>(R.id.buttonNext)
        next.setOnClickListener{
            val intent = Intent(this, ContactDataActivity::class.java)
            startActivity(intent)
        }
    }
}