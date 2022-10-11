package app.android.nycschools.presentation.actvities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import app.android.nycschools.databinding.ActivityMainBinding
import app.android.nycschools.presentation.SchoolListAdapter
import app.android.nycschools.presentation.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var adapter = SchoolListAdapter(emptyList())
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.adapter = adapter
        binding.button.setOnClickListener{
            adapter.updateSchools(emptyList())
            binding.progressBar.visibility = View.VISIBLE
            viewModel.getSchoolList()
        }

        lifecycleScope.launchWhenStarted{
            viewModel.schoolListData.collect {
                View.GONE
                adapter.updateSchools(it)
            }
        }

    }
}