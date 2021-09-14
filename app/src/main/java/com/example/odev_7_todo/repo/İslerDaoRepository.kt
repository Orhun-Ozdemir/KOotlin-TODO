package com.example.odev_7_todo.repo

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.odev_7_todo.room.VeriTabani
import com.example.odev_7_todo.İsler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class İslerDaoRepository(val application: Application) {

    private val vt: VeriTabani
    private val islerListesi: MutableLiveData<List<İsler>>

    init {

        vt = VeriTabani.veritabaniErişim(application)!!
        islerListesi = MutableLiveData()
    }

    fun kisileriGetir(): MutableLiveData<List<İsler>> {

        return islerListesi
    }

    fun tumİsleriAl() {

        val job: Job = CoroutineScope(Dispatchers.Main).launch {
            islerListesi.value = vt.islerDao().tumIsler()

        }


    }

    fun kisiAra(arananKelime: String) {

        val job: Job = CoroutineScope(Dispatchers.Main).launch {
            islerListesi.value = vt.islerDao().isAra(arananKelime)

        }

    }

    fun kisiSil(isler: İsler) {

        val job: Job = CoroutineScope(Dispatchers.Main).launch {
            vt.islerDao().isSil(isler)
            tumİsleriAl()

        }


    }

    fun kisiKayit(isler: İsler) {

        val job: Job = CoroutineScope(Dispatchers.Main).launch {
            vt.islerDao().isEkle(isler)


        }


    }

    fun kisiGuncelle(isler: İsler) {

        val job: Job = CoroutineScope(Dispatchers.Main).launch {
            vt.islerDao().isGuncelle(isler)


        }


    }
}