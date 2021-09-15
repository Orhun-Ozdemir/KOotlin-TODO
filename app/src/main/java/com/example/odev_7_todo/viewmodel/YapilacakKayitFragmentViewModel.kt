package com.example.odev_7_todo.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.odev_7_todo.repo.İslerDaoRepository
import com.example.odev_7_todo.İsler


class YapilacakKayitFragmentViewModel(application: Application): AndroidViewModel(application)
{

    val islerdaor= İslerDaoRepository(application)

    fun kayit(isler:İsler)
    {

        islerdaor.isKayit(isler)

    }




}