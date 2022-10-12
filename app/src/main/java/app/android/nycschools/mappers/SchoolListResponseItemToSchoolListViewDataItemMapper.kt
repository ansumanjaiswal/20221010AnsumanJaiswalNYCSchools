package app.android.nycschools.mappers

import app.android.nycschools.models.NYCSchoolListResponseItem
import app.android.nycschools.models.SchoolViewData
import javax.inject.Inject

class SchoolListResponseItemToSchoolListViewDataItemMapper @Inject constructor() :
    Mapper<NYCSchoolListResponseItem, SchoolViewData> {

    override fun map(params: NYCSchoolListResponseItem): SchoolViewData {
        return SchoolViewData(
            dbn = params.dbn,
            name = params.school_name,
            email = params.school_email,
            address = params.primary_address_line_1,
            city = params.city,
            zip = params.zip
        )
    }
}