package co.edu.udea.compumovil.gr01_20231.lab1.schemas

data class Personal(
    val name: String,
    val lastName: String,
    val gender: String,
    val birthDate: String,
    val schooling: String,
)

data class Contact (
    val name: String,
    val lastName: String,
    val gender: String,
    val birthDate: String,
    val schooling: String,
    val phone: Int,
    val address: String,
    val email: String,
    val country: String,
    val city: String,
)
