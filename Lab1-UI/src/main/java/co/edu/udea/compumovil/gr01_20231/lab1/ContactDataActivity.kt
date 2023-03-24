package co.edu.udea.compumovil.gr01_20231.lab1

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import co.edu.udea.compumovil.gr01_20231.lab1.schemas.Contact
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request

class ContactDataActivity : AppCompatActivity() {
    private val TAG = "Data"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_data)

        val gson = Gson()
        val extras = intent.extras
        var contact = Contact()
        if (extras != null) {
             contact = gson.fromJson(
                extras.getString("personal"), Contact::class.java,
            )
        }

        val phoneInput = findViewById<EditText>(R.id.inputPhone)
        val emailInput = findViewById<EditText>(R.id.inputEmail)
        val countryInput = findViewById<EditText>(R.id.inputCountry)
        val cityInput = findViewById<EditText>(R.id.inputCity)
        val addressInput = findViewById<EditText>(R.id.inputAddress)

        val next = findViewById<Button>(R.id.buttonNext)
        next.setOnClickListener {
            var error = false

            val phone = phoneInput.text.toString()
            if (phone.isEmpty()) {
                phoneInput.error = getString(R.string.required)
                error = true
            }

            val email = emailInput.text.toString()
            if (email.isEmpty()) {
                emailInput.error = getString(R.string.required)
                error = true
            } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                emailInput.error = "It's not Email"
                error = true
            }

            val country = countryInput.text.toString()
            if (country.isEmpty()) {
                countryInput.error = getString(R.string.required)
                error = true
            }

            if (!error) {
                // this.getCountries("co")
                contact.phone = phone.toInt()
                contact.email = email
                contact.country = country
                contact.city = cityInput.text.toString()
                contact.address = addressInput.text.toString()
                Log.d(this.TAG, contact.toString())
            }
        }
    }

    private fun getCountries(namePrefix: String): Array<String>{
        val client = OkHttpClient()

        val request = Request.Builder()
            .url(
                String.format(
                    "https://wft-geo-db.p.rapidapi.com/v1/geo/countries?namePrefix=%s&limit=10",
                    namePrefix,
                )
            )
            .get()
            .addHeader("X-RapidAPI-Key", "")
            .addHeader("X-RapidAPI-Host", "wft-geo-db.p.rapidapi.com")
            .build()

        val response = client.newCall(request).execute()
        val data = response.body?.string() ?: return arrayOf<String>()
        val gson = Gson()
        val map: Map<String, Any> = HashMap()
        val dataJson = gson.fromJson(data, map.javaClass)
        println(dataJson["data"])
        return arrayOf<String>()
    }
}