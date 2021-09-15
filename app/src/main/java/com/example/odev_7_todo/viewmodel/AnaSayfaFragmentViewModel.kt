package com.example.odev_7_todo.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.odev_7_todo.repo.İslerDaoRepository
import com.example.odev_7_todo.İsler

class AnaSayfaFragmentViewModel(application: Application):AndroidViewModel(application)
{

    var islerListesi= MutableLiveData<List<İsler>>()
    val islerdaor= İslerDaoRepository(application)

    init{

        isleriYükle()
        islerListesi=islerdaor.isleriGetir()

    }


    fun isleriYükle()
    {
        islerdaor.tumİsleriAl()
    }

    fun ara(aramaKelimesi:String)
    {
        islerdaor.isAra(aramaKelimesi)
    }

    fun sil(isler:İsler)
    {

        islerdaor.isSil(isler)

    }




}