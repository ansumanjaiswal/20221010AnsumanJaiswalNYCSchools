package app.android.nycschools.mappers

import app.android.nycschools.models.SatScoresResponseItem
import app.android.nycschools.models.SatScoresViewData
import javax.inject.Inject

class SatScoreResponseItemToSatScoreViewItemMapper @Inject constructor() :
    Mapper<SatScoresResponseItem, SatScoresViewData> {

    override fun map(params: SatScoresResponseItem): SatScoresViewData {
        return SatScoresViewData(
            dbn = params.dbn,
            school_name = params.school_name,
            num_of_sat_test_takers = params.num_of_sat_test_takers,
            sat_critical_reading_avg_score = params.sat_critical_reading_avg_score,
            sat_math_avg_score = params.sat_math_avg_score,
            sat_writing_avg_score = params.sat_writing_avg_score)
    }
}