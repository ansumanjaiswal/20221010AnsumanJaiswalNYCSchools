package app.android.nycschools.useCases

import app.android.nycschools.mappers.SchoolListResponseToSchoolListViewDataMapper
import app.android.nycschools.models.NYCSchoolListResponseItem
import app.android.nycschools.models.SchoolViewData
import app.android.nycschools.repositories.Repository

class SchoolListUseCase(
    private val repository: Repository<NYCSchoolListResponseItem>,
    private val mapper: SchoolListResponseToSchoolListViewDataMapper
) : UseCase<List<SchoolViewData>> {

    override suspend fun getData(): List<SchoolViewData> {
        return mapper.map(repository.getData(SCHOOL_LIST_ENDPOIN))
    }

    companion object {
        private const val SCHOOL_LIST_ENDPOIN = "s3k6-pzi2.json"
    }
}