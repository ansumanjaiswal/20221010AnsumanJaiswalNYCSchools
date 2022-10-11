package app.android.nycschools.mappers

import app.android.nycschools.models.SatScoresResponseItem
import app.android.nycschools.models.SatScoresViewData
import javax.inject.Inject

class SatScoreResponseListToSatScoreViewDataListMapper @Inject constructor(
    private val itemMapper: SatScoreResponseItemToSatScoreViewItemMapper
) : Mapper<List<SatScoresResponseItem>, List<SatScoresViewData>> {

    override fun map(params: List<SatScoresResponseItem>): List<SatScoresViewData> {
        return params.map {
            itemMapper.map(it)
        }
    }
}