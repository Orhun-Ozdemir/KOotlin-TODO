package com.example.odev_7_todo.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.odev_7_todo.R
import com.example.odev_7_todo.databinding.FragmentYapilacakDetayBinding
import com.example.odev_7_todo.fragment.YapilacakDetayFragmentArgs


class YapilacakDetayFragment : Fragment() {

    private lateinit var tasarim: FragmentYapilacakDetayBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        tasarim= FragmentYapilacakDetayBinding.inflate(inflater)
        tasarim.yapilicaklarDetayNesnesi=this
        tasarim.yapilacaklarDetayToolbarTitle="Yapılcak İş Detay"

        val bundle:YapilacakDetayFragmentArgs by navArgs()
        tasarim.yapilacakIs=bundle.isNesnesi

        return tasarim.root
    }

    fun isGuncelle(is_id:Int,is_detay:String)
    {



    }


}