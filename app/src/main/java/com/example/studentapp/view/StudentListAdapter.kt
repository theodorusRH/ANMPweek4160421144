package com.example.studentapp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.studentapp.databinding.StudentListItemBinding
import com.example.studentapp.model.Student

class StudentListAdapter(val StudentList:ArrayList<Student>)
    :RecyclerView.Adapter<StudentListAdapter.StudentViewHolder>() {

    class StudentViewHolder(var binding: StudentListItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val binding = StudentListItemBinding.inflate(
            LayoutInflater.from(parent.context),parent,false
        )
        return StudentViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return StudentList.size
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.binding.txtID.text = StudentList[position].id
        holder.binding.txtName.text = StudentList[position].name
        holder.binding.btnDetail.setOnClickListener {
            val action = StudentListFragmentDirections.actionDetailFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }

    fun updateStudentList(newStudenList:ArrayList<Student>){
        StudentList.clear()
        StudentList.addAll(newStudenList)
        notifyDataSetChanged()
    }
}