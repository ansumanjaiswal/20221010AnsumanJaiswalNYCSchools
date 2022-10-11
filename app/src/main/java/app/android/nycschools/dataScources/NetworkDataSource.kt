package app.android.nycschools.dataScources

import app.android.nycschools.models.NYCSchoolListResponseItem

interface NetworkDataSource<T> {

    suspend fun getNetworkData(endpoint: String) : List<T>
}