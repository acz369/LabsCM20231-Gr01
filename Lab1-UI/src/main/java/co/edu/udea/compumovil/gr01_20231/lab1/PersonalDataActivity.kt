package co.edu.udea.compumovil.gr01_20231.lab1

import android.app.DatePickerDialog
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
import java.util.*

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
        next.setOnClickListener {
            var error = false

            val name = nameInput.text.toString()
            if (name.isEmpty()) {
                nameInput.error = getString(R.string.required)
                error = true
            }

            val lastName = lastNameInput.text.toString()
            if (lastName.isEmpty()) {
                lastNameInput.error = getString(R.string.required)
                error = true
            }

            if (!error) {
                val gender = findViewById<RadioButton>(groupRadioButton.checkedRadioButtonId)
                var personalGender = ""
                gender?.let {
                    personalGender = gender.text.toString()
                }

                var schooling = schoolingSpinner.selectedItem.toString()
                if (schooling == resources.getStringArray(R.array.level_schooling)[0]) {
                    schooling = ""
                }

                val personal = Personal(
                    name = name,
                    lastName = lastName,
                    gender = personalGender,
                    birthDate = birthDate.text.toString(),
                    schooling = schooling,
                )
                println(personal)
                val intent = Intent(this, ContactDataActivity::class.java)
                startActivity(intent)
            }
        }

        val buttonChange = findViewById<TextView>(R.id.buttonChange)
        buttonChange.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)
            val datePickerDialog = DatePickerDialog(
                this,
                { _, year, month, day ->
                    birthDate.text = String.format("%s/%02d/%02d", year, month, day)
                },
                year,
                month,
                day
            )
            datePickerDialog.show()
        }
    }
}