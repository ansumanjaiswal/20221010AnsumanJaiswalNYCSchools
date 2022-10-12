package app.android.nycschools.presentation.actvities

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import app.android.nycschools.databinding.ActivitySchoolDetailsBinding
import app.android.nycschools.models.SatScoresViewData
import app.android.nycschools.presentation.viewModel.SchoolDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SchoolDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySchoolDetailsBinding
    private val viewModel: SchoolDetailsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySchoolDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.progressBar.visibility = View.VISIBLE
        //Get the bundle
        val bundle = intent.extras
        //Extract the data…
        val dbn: String = bundle?.getString(DATA_TRANSPORT_KEY).orEmpty()

        viewModel.getSatScores(dbn)
        lifecycleScope.launchWhenStarted {
            viewModel.foundData.collect {
                if (it == null) {
                    handleErrorScenario()
                } else {
                    updateUIForSuccessScenario(it)
                }
            }
        }
    }

    private fun handleErrorScenario() {
        binding.progressBar.visibility = View.GONE

        binding.schoolNameLabel.visibility = View.GONE
        binding.satTestTakersLabel.visibility = View.GONE
        binding.readingAvgScoreLabel.visibility = View.GONE
        binding.mathAvgScoreLabel.visibility = View.GONE
        binding.writingAvgScoreLabel.visibility = View.GONE

        binding.schoolName.visibility = View.GONE
        binding.satTestTakers.visibility = View.GONE
        binding.readingAvgScore.visibility = View.GONE
        binding.mathAvgScore.visibility = View.GONE
        binding.writingAvgScore.visibility = View.GONE

        binding.errorText.visibility = View.VISIBLE
        binding.errorText.text = ERROR_TEXT
    }

    // We can use databinding to update these values and also set visibility
    private fun updateUIForSuccessScenario(it: SatScoresViewData) {
        binding.progressBar.visibility = View.GONE
        binding.errorText.visibility = View.GONE

        binding.schoolName.text = it.school_name
        binding.satTestTakers.text = it.num_of_sat_test_takers
        binding.readingAvgScore.text = it.sat_critical_reading_avg_score
        binding.mathAvgScore.text = it.sat_math_avg_score
        binding.writingAvgScore.text = it.sat_writing_avg_score
    }

    companion object {
        const val ERROR_TEXT = "Error in fetching data"
        const val DATA_TRANSPORT_KEY = "DBN"
    }
}
/*
* The layout file could be updated to get margins and text sizes from dimens file
* Get string resources (eg labels) from string resources
* We can also wrap the data form (ie. all textviews displaying final data into a layout to handle
* visibility more elegantly.
* */