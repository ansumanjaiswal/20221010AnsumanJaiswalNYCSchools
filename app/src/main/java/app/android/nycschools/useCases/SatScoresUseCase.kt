package app.android.nycschools.useCases

import app.android.nycschools.mappers.SatScoreResponseListToSatScoreViewDataListMapper
import app.android.nycschools.models.SatScoresResponseItem
import app.android.nycschools.models.SatScoresViewData
import app.android.nycschools.repositories.Repository

class SatScoresUseCase(
    private val repository: Repository<SatScoresResponseItem>,
    private val mapper: SatScoreResponseListToSatScoreViewDataListMapper
): UseCase<List<SatScoresViewData>> {

    override suspend fun getData(): List<SatScoresViewData> {
        return mapper.map(repository.getData(endpoint = SAT_SCORES_ENDPOINT))
    }

    companion object {
        private const val SAT_SCORES_ENDPOINT = "f9bf-2cp4.json"
    }
}