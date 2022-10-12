package app.android.nycschools.mappers

import app.android.nycschools.models.NYCSchoolListResponseItem
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class SchoolListResponseItemToSchoolListViewDataItemTest {

    lateinit var sut: SchoolListResponseItemToSchoolListViewDataItemMapper

    @Before
    fun setup(){
        sut = SchoolListResponseItemToSchoolListViewDataItemMapper()
    }

    @Test
    fun `When map method is called, correct mapped data is returned`(){
        // Given
        val stubSchoolListItem = NYCSchoolListResponseItem(
            dbn = "DBN",
            school_name = "School name",
            school_email = "school email",
            primary_address_line_1 = "Address line 1",
            city = "NYC",
            zip = "100000"
        )

        // When
        val response = sut.map(stubSchoolListItem)

        // Then
        Assert.assertEquals(stubSchoolListItem.dbn, response.dbn)
        Assert.assertEquals(stubSchoolListItem.school_name, response.name)
        Assert.assertEquals(stubSchoolListItem.school_email, response.email)
        Assert.assertEquals(stubSchoolListItem.primary_address_line_1, response.address)
        Assert.assertEquals(stubSchoolListItem.city, response.city)
        Assert.assertEquals(stubSchoolListItem.zip, response.zip)
    }
}