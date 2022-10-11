package app.android.nycschools.dataScources

import app.android.nycschools.models.NYCSchoolListResponseItem
import app.android.nycschools.network.SchoolListService

class SchoolListNetworkDataSource(private val service: SchoolListService): NetworkDataSource<NYCSchoolListResponseItem> {

    override suspend fun getNetworkData(endpoint: String): List<NYCSchoolListResponseItem> {
        val response = service.listRepos(endpoint)
        if (response.isSuccessful && !response.body().isNullOrEmpty()){
            return response.body()!!
        }
        return emptyList()
    }
}