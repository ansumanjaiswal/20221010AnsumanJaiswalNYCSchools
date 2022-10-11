package app.android.nycschools.mappers

import app.android.nycschools.models.SatScoresResponseItem
import app.android.nycschools.models.SatScoresViewData
import javax.inject.Inject

class SatScoreResponseItemToSatScoreViewItemMapper @Inject constructor() :
    Mapper<SatScoresResponseItem, SatScoresViewData> {

    override fun map(params: SatScoresResponseItem): SatScoresViewData {
        return SatScoresViewData(params.school_name, params.sat_writing_avg_score)
    }
}