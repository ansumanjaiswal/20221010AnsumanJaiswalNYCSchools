package app.android.nycschools.dataScources

import app.android.nycschools.models.SatScoresResponseItem
import app.android.nycschools.network.SatScoresService

class SatScoresDataSource(private val service: SatScoresService): NetworkDataSource<SatScoresResponseItem> {

    override suspend fun getNetworkData(endpoint: String): List<SatScoresResponseItem> {
        val response = service.getSatScores(endpoint)
        if (response.isSuccessful && !response.body().isNullOrEmpty()){
            return response.body()!!
        }
        return emptyList()    }
}