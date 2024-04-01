package com.example.studentapp.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.studentapp.databinding.CarListItemBinding
import com.example.studentapp.model.Mobil

class CarListAdapter(val CarList:ArrayList<Mobil>)
    : RecyclerView.Adapter<CarListAdapter.CarViewHolder>() {

    class CarViewHolder(var binding: CarListItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val binding = CarListItemBinding.inflate(
            LayoutInflater.from(parent.context),parent,false
        )
        return CarListAdapter.CarViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return CarList.size
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        holder.binding.txtID.text = CarList[position].id.toString()
        holder.binding.txtName.text = CarList[position].maker
        holder.binding.textModel.text = CarList[position].model
        holder.binding.txtYear.text = CarList[position].year.toString()
        holder.binding.textColor.text = CarList[position].color
//        holder.binding.txtFeature.text = CarList[position].feature
    }
}