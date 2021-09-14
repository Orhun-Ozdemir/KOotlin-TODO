package com.example.odev_7_todo.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.odev_7_todo.R
import com.example.odev_7_todo.databinding.FragmentYapilacakKayitBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

class YapilacakKayitFragment : Fragment() {

  private lateinit var tasarim:FragmentYapilacakKayitBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        tasarim= FragmentYapilacakKayitBinding.inflate(inflater)

        tasarim.yapilacaklarKayitToolbarTitle="Yapılacak İş Kayıt"
        //tasarim.yapilacakKayitNesnesi=this

        return tasarim.root
    }

    fun isKayıt(is_detay:String)
    {



    }


}