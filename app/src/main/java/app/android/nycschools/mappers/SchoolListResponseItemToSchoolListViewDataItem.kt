package app.android.nycschools.mappers

import app.android.nycschools.models.NYCSchoolListResponseItem
import app.android.nycschools.models.SchoolViewData
import javax.inject.Inject

class SchoolListResponseItemToSchoolListViewDataItem @Inject constructor(): Mapper<NYCSchoolListResponseItem, SchoolViewData> {

    override fun map(params: NYCSchoolListResponseItem): SchoolViewData {
        return SchoolViewData(params.school_name)
    }
}