package app.android.nycschools.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.android.nycschools.models.SchoolViewData
import app.android.nycschools.useCases.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SchoolListViewModel @Inject constructor(private val useCase: UseCase<List<SchoolViewData>>): ViewModel() {

    private val _schoolListData = MutableSharedFlow<List<SchoolViewData>>()
    val schoolListData = _schoolListData.asSharedFlow()

    fun getSchoolList() {
        viewModelScope.launch(Dispatchers.IO) {
            val schoolList = useCase.getData()
            Dispatchers.Main
            _schoolListData.emit(schoolList)
        }
    }

}