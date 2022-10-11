package app.android.nycschools.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.android.nycschools.models.SatScoresViewData
import app.android.nycschools.useCases.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SchoolDetailsViewModel @Inject constructor(private val useCase: UseCase<List<SatScoresViewData>>): ViewModel() {
    private val _satScoresData = MutableSharedFlow<SatScoresViewData>()
    val satScoresData = _satScoresData.asSharedFlow()

    fun getSatScores(dbn: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val schoolList = useCase.getData()
            val requiredData = schoolList.find { dbn == it.dbn }
            Dispatchers.Main
            requiredData?.let { _satScoresData.emit(it) }
        }
    }

}