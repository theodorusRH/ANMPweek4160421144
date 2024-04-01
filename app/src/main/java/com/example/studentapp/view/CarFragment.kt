package com.example.studentapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.studentapp.databinding.FragmentCarBinding
import com.example.studentapp.viewmodel.CarViewModel

class CarFragment : Fragment() {

    private lateinit var carModelView: CarViewModel
    private lateinit var binding: FragmentCarBinding
    private val carListAdapter = CarListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCarBinding.inflate(inflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        carModelView = ViewModelProvider(this).get(carModelView::class.java)
        carModelView.refresh()

        binding.recView.layoutManager = LinearLayoutManager(context)
        binding.recView.adapter = carListAdapter

        binding.refreshLayout.setOnRefreshListener {
            binding.recView.visibility= View.GONE
            binding.textError.visibility = View.GONE
            binding.progressLoad.visibility = View.VISIBLE
            carModelView.refresh()
            binding.refreshLayout.isRefreshing = false

        }
        observeViewModel()
    }

    fun observeViewModel(){
        carModelView.loadingLD.observe(viewLifecycleOwner,Observer{
            if(it == true){
                binding.recView.visibility = View.GONE
                binding.progressLoad.visibility = View.VISIBLE
            } else{
                binding.recView.visibility = View.VISIBLE
                binding.progressLoad.visibility = View.GONE
            }
        })

        carModelView.carLoadErrorLD.observe(viewLifecycleOwner,Observer{
            if(it == true) {
                binding.textError?.visibility = View.VISIBLE
            } else {
                binding.textError?.visibility = View.GONE
            }
        })
    }

}