package app.android.nycschools.dagger

import app.android.nycschools.mappers.SatScoreResponseListToSatScoreViewDataListMapper
import app.android.nycschools.mappers.SchoolListResponseToSchoolListViewDataMapper
import app.android.nycschools.models.NYCSchoolListResponseItem
import app.android.nycschools.models.SatScoresResponseItem
import app.android.nycschools.models.SatScoresViewData
import app.android.nycschools.models.SchoolViewData
import app.android.nycschools.repositories.Repository
import app.android.nycschools.repositories.SchoolListRemoteRepository
import app.android.nycschools.useCases.SatScoresUseCase
import app.android.nycschools.useCases.SchoolListUseCase
import app.android.nycschools.useCases.UseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @Provides
    fun provideSchoolListUseCase(repository: Repository<NYCSchoolListResponseItem>,
                                 mapper: SchoolListResponseToSchoolListViewDataMapper)
    : UseCase<List<SchoolViewData>> {
        return SchoolListUseCase(repository, mapper)
    }

    @Provides
    fun provideSatScoresUseCase(repository: Repository<SatScoresResponseItem>,
                                mapper: SatScoreResponseListToSatScoreViewDataListMapper
    )
            : UseCase<List<SatScoresViewData>> {
        return SatScoresUseCase(repository, mapper)
    }
}