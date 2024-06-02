package com.example.studentapp.view

import android.view.View

interface ButtonClickListener{
    fun onButtonClick(v: View)
}

interface NotifClickListener{
    fun onNotifClickListener(v: View)
}

interface UpdateClickListener{
    fun onUpdateClickListener(v: View)
}