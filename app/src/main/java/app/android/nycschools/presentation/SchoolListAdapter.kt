package app.android.nycschools.presentation

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
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
        val schoolName: TextView
        val address: TextView
        val city: TextView
        val zip: TextView
        val email: TextView
        val rootLayout: ConstraintLayout

        init {
            schoolName = view.findViewById(R.id.schoolName)
            address = view.findViewById(R.id.address)
            city = view.findViewById(R.id.city)
            zip = view.findViewById(R.id.zip)
            email = view.findViewById(R.id.email)
            rootLayout = view.findViewById(R.id.rootLayout)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.schools_view_holder, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.schoolName.text = schoolList[position].name
        holder.address.text = schoolList[position].address
        holder.city.text = schoolList[position].city
        holder.zip.text = schoolList[position].zip
        holder.email.text = schoolList[position].email
        holder.rootLayout.setOnClickListener{
            val intent = Intent(it.context, SchoolDetailsActivity::class.java)
            val bundle = Bundle()
            bundle.putString("DBN", schoolList[position].dbn)
            intent.putExtras(bundle)
            it.context.startActivity(intent)
            Toast.makeText(it.context, "CLICKED", Toast.LENGTH_LONG).show()
        }
    }

    override fun getItemCount(): Int {
        return schoolList.size
    }
}