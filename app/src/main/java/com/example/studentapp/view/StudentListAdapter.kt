package com.example.studentapp.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.studentapp.databinding.StudentListItemBinding
import com.example.studentapp.model.Student
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception

class StudentListAdapter(val StudentList:ArrayList<Student>)
    :RecyclerView.Adapter<StudentListAdapter.StudentViewHolder>(), ButtonClickListener{

    class StudentViewHolder(
        val binding: StudentListItemBinding):RecyclerView.ViewHolder(binding.root)

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

        holder.binding.student = StudentList[position]
        holder.binding.listener = this
//        val picasso = Picasso.Builder(holder.itemView.context)
//        picasso.listener { picasso, uri, exception ->
//            exception.printStackTrace()
//        }
//        picasso.build().load(StudentList[position].photourl).into(holder.binding.imageStudent, object:Callback{
//            override fun onSuccess() {
//                holder.binding.progressImage.visibility=View.INVISIBLE
//                holder.binding.imageStudent.visibility=View.VISIBLE
//            }
//
//            override fun onError(e: Exception?) {
//                Log.e("picasso_error",e.toString())
//            }
//
//        })
//
//        holder.binding.txtID.text = StudentList[position].id
//        holder.binding.txtName.text = StudentList[position].name
//        holder.binding.btnDetail.setOnClickListener {
//            val action = StudentListFragmentDirections.actionDetailFragment()
//            Navigation.findNavController(it).navigate(action)
//        }
    }

    fun updateStudentList(newStudenList:ArrayList<Student>){
        StudentList.clear()
        StudentList.addAll(newStudenList)
        notifyDataSetChanged()
    }

    override fun onButtonClick(v: View) {
        val action = StudentListFragmentDirections.actionDetailFragment(v.tag.toString())
        Navigation.findNavController(v).navigate(action)
    }
}