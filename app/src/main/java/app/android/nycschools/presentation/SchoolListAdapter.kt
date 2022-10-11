package app.android.nycschools.presentation

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import app.android.nycschools.R
import app.android.nycschools.models.SchoolViewData
import app.android.nycschools.presentation.actvities.SchoolDetailsActivity

class SchoolListAdapter(private var schoolList: List<SchoolViewData>) :
    Adapter<SchoolListAdapter.ViewHolder>() {

    fun updateSchools(schools: List<SchoolViewData>) {
        this.schoolList = schools
        this.notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView

        init {
            textView = view.findViewById(R.id.schoolName)
            view.setOnClickListener {
                val intent = Intent(it.context, SchoolDetailsActivity::class.java)
                it.context.startActivity(intent)
                Toast.makeText(view.context, "CLICKED", Toast.LENGTH_LONG).show()
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.schools_view_holder, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = schoolList[position].name
    }

    override fun getItemCount(): Int {
        return schoolList.size
    }
}