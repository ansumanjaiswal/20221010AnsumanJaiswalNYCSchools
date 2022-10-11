package app.android.nycschools.repositories

import app.android.nycschools.dataScources.NetworkDataSource
import app.android.nycschools.models.SatScoresResponseItem

class SatScoresRemoteRepository(private val dataSource:
                                 NetworkDataSource<SatScoresResponseItem>)
    : Repository<SatScoresResponseItem> {

    override suspend fun getData(endpoint: String): List<SatScoresResponseItem> {
        return dataSource.getNetworkData(endpoint)
    }
}