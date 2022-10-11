package app.android.nycschools.dagger

import app.android.nycschools.dataScources.NetworkDataSource
import app.android.nycschools.models.NYCSchoolListResponseItem
import app.android.nycschools.models.SatScoresResponseItem
import app.android.nycschools.repositories.Repository
import app.android.nycschools.repositories.SatScoresRemoteRepository
import app.android.nycschools.repositories.SchoolListRemoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideSchoolListRemoteRepository(networkDataSource: NetworkDataSource<NYCSchoolListResponseItem>): Repository<NYCSchoolListResponseItem> {
        return SchoolListRemoteRepository(networkDataSource)
    }

    @Provides
    fun provideSatScoresRemoteRepository(networkDataSource: NetworkDataSource<SatScoresResponseItem>): Repository<SatScoresResponseItem> {
        return SatScoresRemoteRepository(networkDataSource)
    }
}