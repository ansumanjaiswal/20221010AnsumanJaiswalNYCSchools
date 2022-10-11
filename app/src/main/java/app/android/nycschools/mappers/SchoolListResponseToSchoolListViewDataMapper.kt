package app.android.nycschools.mappers

import app.android.nycschools.models.NYCSchoolListResponseItem
import app.android.nycschools.models.SchoolViewData
import javax.inject.Inject

class SchoolListResponseToSchoolListViewDataMapper @Inject constructor(
    private val itemMapper: SchoolListResponseItemToSchoolListViewDataItem
) :
    Mapper<List<NYCSchoolListResponseItem>, List<SchoolViewData>> {

    override fun map(params: List<NYCSchoolListResponseItem>): List<SchoolViewData> {
        return params.map {
            itemMapper.map(it)
        }
    }
}