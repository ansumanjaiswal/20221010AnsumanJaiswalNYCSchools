package app.android.nycschools.models

data class NYCSchoolListResponseItem(
    val dbn: String,
    val school_name: String,
    val school_email: String? = "",
    val primary_address_line_1: String,
    val city: String,
    val zip: String,
)
