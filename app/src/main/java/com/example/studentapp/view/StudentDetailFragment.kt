package com.example.studentapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.studentapp.R
import com.example.studentapp.databinding.FragmentStudentDetailBinding
import com.example.studentapp.viewmodel.DetailViewModel


class StudentDetailFragment : Fragment() {

    private lateinit var detailView: DetailViewModel
    private lateinit var binding: FragmentStudentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        detailView = ViewModelProvider(this).get(DetailViewModel::class.java)
        detailView.fetch()

        observeDetailModel()
    }

    fun observeDetailModel(){
        detailView.studentLD.observe(viewLifecycleOwner, Observer{
            if(it != null){
                binding.txtID.setText(it.id)
                binding.txtName.setText(it.name)
                binding.txtBod.setText(it.dob)
                binding.editTextText4.setText(it.phone)
            }
        })

    }

}