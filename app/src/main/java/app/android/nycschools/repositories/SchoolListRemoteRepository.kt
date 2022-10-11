package app.android.nycschools.repositories

import app.android.nycschools.dataScources.NetworkDataSource
import app.android.nycschools.models.NYCSchoolListResponseItem

class SchoolListRemoteRepository(private val dataSource: NetworkDataSource<NYCSchoolListResponseItem>): Repository<NYCSchoolListResponseItem> {

    override suspend fun getData(endpoint: String): List<NYCSchoolListResponseItem> {
        return dataSource.getNetworkData(endpoint)
    }
}