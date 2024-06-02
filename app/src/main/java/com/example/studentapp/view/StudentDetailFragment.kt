package com.example.studentapp.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.studentapp.R
import com.example.studentapp.databinding.FragmentStudentDetailBinding
import com.example.studentapp.viewmodel.DetailViewModel
import com.squareup.picasso.Picasso
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit


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
        detailView.fetch(id = String())

        binding.updatelistener= this
        binding.notifListener= this
        observeDetailModel()
    }

    @SuppressLint("CheckResult")
    fun observeDetailModel(){

        detailView.studentsLD.observe(viewLifecycleOwner, Observer {
            binding.student = it

//            val btnUpdate = view?.findViewById<Button>(R.id.btnUpdate)
//            btnUpdate?.setOnClickListener {
//                Observable.timer(5, TimeUnit.SECONDS)
//                    .subscribeOn(Schedulers.io())
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .subscribe {
//                        Log.d("Messages", "five seconds")
//                        MainActivity.showNotification(
//                            student.name.toString(),
//                            "A new notification created",
//                            R.drawable.baseline_person_24
//                        )
//                    }
//            }
//
//            if (it == null) {
//            } else {
//                binding.txtID.setText(it.id)
//                binding.txtName.setText(it.name)
//                binding.txtBod.setText(it.dob)
//                binding.editTextText4.setText(it.phone)
//                val picasso = Picasso.Builder(binding.root.context)
//                picasso.listener{picasso,uri,exception->exception.printStackTrace()}
//                picasso.build().load(it.photourl).into(binding.imageView)
//            }
        })
    }
    override fun onNotifClickListener(v: View){
        Observable.timer(3, TimerUnit.SECONDS)
            .subscribeOn(scheduler.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{
                Log.d("Messages","please wait for 3 seconds")
                MainActivity.showNotification(
                    binding.student!!.name!!.toString(),
                    "new notification",
                    R.drawable.baseline_person_24
                )
                Log.d("Messages","notification")
            }
    }

    override fun onUpdateClickListener(v: View) {
        Log.d("update","success")
    }

}