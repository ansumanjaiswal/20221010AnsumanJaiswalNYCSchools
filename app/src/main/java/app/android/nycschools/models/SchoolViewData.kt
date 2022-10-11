package app.android.nycschools.models

data class SchoolViewData(
    val dbn: String,
    val name: String,
    val address: String,
    val city: String,
    val zip: String,
    val email: String? = ""
)
