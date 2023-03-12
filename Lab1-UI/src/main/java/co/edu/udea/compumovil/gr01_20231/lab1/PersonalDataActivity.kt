package co.edu.udea.compumovil.gr01_20231.lab1

import androidx.appcompat.app.AppCompatActivity
import co.edu.udea.compumovil.gr01_20231.lab1.schemas.Personal
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.RadioButton
import android.widget.Spinner
import android.widget.TextView

class PersonalDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_data)

        val nameInput = findViewById<EditText>(R.id.inputName)
        val lastNameInput = findViewById<EditText>(R.id.inputLastName)
        val groupRadioButton = findViewById<RadioGroup>(R.id.radioGroup)
        val birthDate = findViewById<TextView>(R.id.birthDate)
        val schoolingSpinner = findViewById<Spinner>(R.id.pickerListSchooling)

        val next = findViewById<Button>(R.id.buttonNext)
        next.setOnClickListener{
            val gender = findViewById<RadioButton>(groupRadioButton.checkedRadioButtonId)
            val personal = Personal(
                name=nameInput.text.toString(),
                lastName=lastNameInput.text.toString(),
                gender=gender.text.toString(),
                birthDate=birthDate.text.toString(),
                schooling=schoolingSpinner.selectedItem.toString()
            )
            println(personal)
            val intent = Intent(this, ContactDataActivity::class.java)
            startActivity(intent)
        }
    }
}