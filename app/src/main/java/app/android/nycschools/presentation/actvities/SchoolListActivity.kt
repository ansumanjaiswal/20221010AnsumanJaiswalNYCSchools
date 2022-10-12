package app.android.nycschools.presentation.actvities

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import app.android.nycschools.databinding.ActivityMainBinding
import app.android.nycschools.presentation.SchoolListAdapter
import app.android.nycschools.presentation.viewModel.SchoolListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SchoolListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var adapter = SchoolListAdapter(emptyList())
    private val viewModel: SchoolListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.adapter = adapter
        binding.progressBar.visibility = View.VISIBLE

        lifecycleScope.launchWhenStarted{
            viewModel.schoolListData.collect {
                binding.progressBar.visibility = View.GONE
                if(it.isEmpty()){
                    handleErrorScenario()
                }
                adapter.updateSchools(it)
            }
        }

        viewModel.getSchoolList()
    }

    private fun handleErrorScenario() {
        binding.errorText.visibility = View.VISIBLE
        binding.errorText.text = ERROR_TEXT
    }

    companion object {
        const val ERROR_TEXT = "Error in fetching data"
    }
}