package com.example.odev_7_todo.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.odev_7_todo.repo.İslerDaoRepository
import com.example.odev_7_todo.İsler



class YapilacakDetayFragmentViewModel(application: Application): AndroidViewModel(application)
{
    val islerdaor= İslerDaoRepository(application)

    fun guncelle(isler: İsler)
    {

        islerdaor.isGuncelle(isler)

    }




}