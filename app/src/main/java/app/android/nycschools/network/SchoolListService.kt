package app.android.nycschools.network

import app.android.nycschools.models.NYCSchoolListResponseItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

interface SchoolListService {

    @GET()
    suspend fun listRepos(@Url apiEndpoint: String): Response<List<NYCSchoolListResponseItem>>
}