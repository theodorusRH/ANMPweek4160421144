package com.example.studentapp.viewmodel


import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.studentapp.model.Student
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DetailViewModel(application: Application): AndroidViewModel(application) {
    var studentsLD = MutableLiveData<Student>()
//    val studentLoadErrorLD = MutableLiveData<Boolean>()
//    val loadingLD = MutableLiveData<Boolean>()
    val TAG = "volleyTag"
    private var queue:RequestQueue? = null

    fun fetch(id:String) {

        queue = Volley.newRequestQueue(getApplication())
        val url = "http://adv.jitusolution.com/student.php?id=${id}"

        val stringRequest = StringRequest(
            Request.Method.GET,
            url,{response ->
//                val sType = object : TypeToken<List<Student>>() { }.type
//                val result = Gson().fromJson<List<Student>>(it, sType)
//                studentsLD.value = result as ArrayList<Student>?
//
//                loadingLD.value = false

                studentsLD.value = Gson().fromJson(response, Student::class.java)
                Log.d("showvolley",response)
            },
            {
//                loadingLD.value = false
//                studentLoadErrorLD.value=false
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