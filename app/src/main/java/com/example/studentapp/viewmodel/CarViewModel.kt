package com.example.studentapp.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.studentapp.model.Mobil
import com.example.studentapp.model.Student
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CarViewModel (application: Application):AndroidViewModel(application){
    var carLD = MutableLiveData<ArrayList<Mobil>>()
    val carLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()
    val TAG = "volleyTag"
    private var queue: RequestQueue? = null

    fun refresh() {
        Log.d("CEKMASUK","MASUK VOLLEY")
        queue = Volley.newRequestQueue(getApplication())
        val url = "http://10.0.2.2/car/cars.json"

        val stringRequest = StringRequest(
            Request.Method.GET,
            url,{
                val sType = object : TypeToken<List<Mobil>>() { }.type
                val result = Gson().fromJson<List<Mobil>>(it, sType)
                carLD.value = result as ArrayList<Mobil>?

                loadingLD.value = false
                Log.d("showvolley",it)
            },
            {
                loadingLD.value = false
                carLoadErrorLD.value=false
                Log.d("showvolley",it.toString())
            }
        )
        stringRequest.tag = TAG
        queue?.add(stringRequest)

    }

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}