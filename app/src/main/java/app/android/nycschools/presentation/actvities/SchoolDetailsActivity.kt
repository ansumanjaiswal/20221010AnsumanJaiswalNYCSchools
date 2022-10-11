package app.android.nycschools.presentation.actvities

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import app.android.nycschools.databinding.ActivitySchoolDetailsBinding
import app.android.nycschools.presentation.viewModel.SchoolDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class SchoolDetailsActivity: AppCompatActivity() {

    private lateinit var binding: ActivitySchoolDetailsBinding
    private val viewModel: SchoolDetailsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySchoolDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getSatScores()
        lifecycleScope.launchWhenStarted {
            viewModel.satScoresData.collect()
        }
    }
}