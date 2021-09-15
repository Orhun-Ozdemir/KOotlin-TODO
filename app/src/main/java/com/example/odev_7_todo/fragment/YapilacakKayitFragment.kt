package com.example.odev_7_todo.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.odev_7_todo.R
import com.example.odev_7_todo.databinding.FragmentYapilacakKayitBinding
import com.example.odev_7_todo.viewmodel.YapilacakKayitFragmentViewModel
import com.example.odev_7_todo.viewmodelfactory.YapilacakKayitFragmentViewModelFactory
import com.example.odev_7_todo.İsler

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

class YapilacakKayitFragment : Fragment() {

  private lateinit var tasarim:FragmentYapilacakKayitBinding
  private lateinit var viewModel:YapilacakKayitFragmentViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        tasarim= FragmentYapilacakKayitBinding.inflate(inflater)
        tasarim.yapilacaklarKayitNesnensi=this


        tasarim.yapilacaklarKayitToolbarTitle="Yapılacak İş Kayıt"
        //tasarim.yapilacakKayitNesnesi=this

        return tasarim.root
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //delegate
        val tempviewModel:YapilacakKayitFragmentViewModel by viewModels(){

            YapilacakKayitFragmentViewModelFactory(requireActivity().application)
        }
        viewModel=tempviewModel
    }



    fun isKayit(is_detay:String)
    {
        val isler: İsler = İsler(0,is_detay)
        viewModel.kayit(isler)


    }


}