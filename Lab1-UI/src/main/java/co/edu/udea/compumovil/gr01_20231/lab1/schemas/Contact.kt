package co.edu.udea.compumovil.gr01_20231.lab1.schemas

data class Personal(
    val name: String,
    val lastName: String,
    val gender: String,
    val birthDate: String,
    val schooling: String,
)

data class Contact (
    val name: String = "",
    val lastName: String = "",
    val gender: String = "",
    val birthDate: String = "",
    val schooling: String = "",
    var phone: Int = 0,
    var address: String = "",
    var email: String = "",
    var country: String = "",
    var city: String = "",
)
