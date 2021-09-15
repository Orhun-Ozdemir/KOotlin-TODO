package com.example.odev_7_todo.viewmodelfactory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.odev_7_todo.viewmodel.AnaSayfaFragmentViewModel

class AnaSayfaFragmentViewModelFactory(private val application: Application)
    :ViewModelProvider.NewInstanceFactory()
{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AnaSayfaFragmentViewModel(application) as T
    }



}