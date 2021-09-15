package com.example.odev_7_todo.viewmodelfactory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.odev_7_todo.viewmodel.YapilacakKayitFragmentViewModel


class YapilacakKayitFragmentViewModelFactory(private val application: Application)
    : ViewModelProvider.NewInstanceFactory()
{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return YapilacakKayitFragmentViewModel(application) as T
    }



}