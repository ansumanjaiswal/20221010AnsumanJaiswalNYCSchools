package app.android.nycschools.mappers

import app.android.nycschools.models.SatScoresResponseItem
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class SatScoreResponseItemToSatScoreViewItemMapperTest {

    lateinit var sut: SatScoreResponseItemToSatScoreViewItemMapper

    @Before
    fun setup(){
        sut = SatScoreResponseItemToSatScoreViewItemMapper()
    }

    @Test
    fun `When map method is called, correct mapped data is returned`(){
        // Given
        val stubSchoolListItem = SatScoresResponseItem(
            dbn = "DBN",
            school_name = "School name",
            num_of_sat_test_takers = "num_of_sat_test_takers",
            sat_critical_reading_avg_score = "sat_critical_reading_avg_score",
            sat_math_avg_score = "sat_math_avg_score",
            sat_writing_avg_score = "sat_writing_avg_score"
        )

        // When
        val response = sut.map(stubSchoolListItem)

        // Then
        Assert.assertEquals(stubSchoolListItem.dbn, response.dbn)
        Assert.assertEquals(stubSchoolListItem.school_name, response.school_name)
        Assert.assertEquals(stubSchoolListItem.num_of_sat_test_takers, response.num_of_sat_test_takers)
        Assert.assertEquals(stubSchoolListItem.sat_critical_reading_avg_score, response.sat_critical_reading_avg_score)
        Assert.assertEquals(stubSchoolListItem.sat_math_avg_score, response.sat_math_avg_score)
        Assert.assertEquals(stubSchoolListItem.sat_writing_avg_score, response.sat_writing_avg_score)
    }
}