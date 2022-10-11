package app.android.nycschools.dagger

import app.android.nycschools.dataScources.NetworkDataSource
import app.android.nycschools.dataScources.SatScoresDataSource
import app.android.nycschools.dataScources.SchoolListNetworkDataSource
import app.android.nycschools.models.NYCSchoolListResponseItem
import app.android.nycschools.models.SatScoresResponseItem
import app.android.nycschools.network.SatScoresService
import app.android.nycschools.network.SchoolListService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    fun provideGetSchoolListNetworkDataSource(service: SchoolListService) : NetworkDataSource<NYCSchoolListResponseItem> {
        return SchoolListNetworkDataSource(service)
    }

    @Provides
    fun provideGetSatScoresNetworkDataSource(service: SatScoresService) : NetworkDataSource<SatScoresResponseItem> {
        return SatScoresDataSource(service)
    }
}