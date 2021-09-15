package com.example.odev_7_todo.fragment

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.odev_7_todo.R
import com.example.odev_7_todo.adapter.YapilacakİslerAdapter
import com.example.odev_7_todo.databinding.FragmentAnaSayfaBinding
import com.example.odev_7_todo.İsler
import com.example.odev_7_todo.viewmodel.AnaSayfaFragmentViewModel
import com.example.odev_7_todo.viewmodelfactory.AnaSayfaFragmentViewModelFactory


class AnaSayfaFragment : Fragment(),SearchView.OnQueryTextListener {

    private lateinit var tasarim: FragmentAnaSayfaBinding
    private lateinit var viewModel: AnaSayfaFragmentViewModel
    private lateinit var yapilacakIslerAdapter: YapilacakİslerAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        tasarim = FragmentAnaSayfaBinding.inflate(inflater)

        tasarim.anaSayfaToolBarTitle = "Yapilacak İşler"
        tasarim.anaSayfaFragemnt=this


        (activity as AppCompatActivity).setSupportActionBar(tasarim.toolbar)

        viewModel.islerListesi.observe(viewLifecycleOwner,{islerListesi->

            yapilacakIslerAdapter= YapilacakİslerAdapter(requireContext(),islerListesi,viewModel)
            tasarim.yapilacakislerAdapter=yapilacakIslerAdapter
        })

        return tasarim.root
    }


    fun kayitSayfasi(v:View) {

        /*var direction = AnaSayfaFragmentDirections.anaSayfaToKayit();
        Navigation.findNavController(tasarim.root).navigate(direction)*/
        Navigation.findNavController(v).navigate(R.id.yapilacakKayitFragment)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        val tempviewModel:AnaSayfaFragmentViewModel by viewModels() {

            AnaSayfaFragmentViewModelFactory(requireActivity().application)
        }
        viewModel=tempviewModel
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        // tasarımsal şeyleri yazılıma aktarmak için
        inflater.inflate(R.menu.menu_item, menu)

        val item = menu.findItem(R.id.search_item)
        val searchView = item.actionView as SearchView
        searchView.setOnQueryTextListener(this)

        super.onCreateOptionsMenu(menu, inflater)
    }
    
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId)
        {
            R.id.search_item ->{
                Toast.makeText(requireContext(),"Ara tıklandı", Toast.LENGTH_SHORT).show()
                return true
            }
            
            else -> return super.onOptionsItemSelected(item)

        }


    }

    override fun onQueryTextSubmit(query: String): Boolean {
        Log.e("Arama tuşa basilinca",query)
        viewModel.ara(query)
      return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        Log.e("Arama harf girdikce",newText)
        viewModel.ara(newText)

        return true
    }
    override fun onResume() {
        super.onResume()
        viewModel.isleriYükle()
    }
}


