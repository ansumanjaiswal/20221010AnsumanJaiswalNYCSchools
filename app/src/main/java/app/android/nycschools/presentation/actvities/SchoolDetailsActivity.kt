package app.android.nycschools.presentation.actvities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import app.android.nycschools.databinding.ActivitySchoolDetailsBinding
import app.android.nycschools.presentation.viewModel.SchoolDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class SchoolDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySchoolDetailsBinding
    private val viewModel: SchoolDetailsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySchoolDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Get the bundle
        val bundle = intent.extras
        //Extract the data…
        val dbn: String = bundle?.getString("DBN").orEmpty()

        viewModel.getSatScores(dbn)
        lifecycleScope.launchWhenStarted {
            viewModel.satScoresData.collect()
        }
    }
}