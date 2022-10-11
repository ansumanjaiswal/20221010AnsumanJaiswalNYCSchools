package app.android.nycschools.repositories

import app.android.nycschools.dataScources.SchoolListNetworkDataSource
import app.android.nycschools.models.NYCSchoolListResponseItem

interface Repository<T> {

    suspend fun getData(endpoint: String): List<T>
}