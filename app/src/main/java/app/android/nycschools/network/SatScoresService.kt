package app.android.nycschools.network

import app.android.nycschools.models.SatScoresResponseItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface SatScoresService {
    @GET()
    suspend fun getSatScores(@Url apiEndpoint: String): Response<List<SatScoresResponseItem>>
}