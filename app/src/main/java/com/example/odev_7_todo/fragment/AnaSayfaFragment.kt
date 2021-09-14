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


class AnaSayfaFragment : Fragment(),SearchView.OnQueryTextListener {

    private lateinit var tasarim: FragmentAnaSayfaBinding
    private val viewmodel: AnaSayfaFragmentViewModel by viewModels()
    private lateinit var yapilacakIslerAdapter: YapilacakİslerAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        tasarim = FragmentAnaSayfaBinding.inflate(inflater)

        tasarim.anaSayfaToolBarTitle = "Yapilacak İşler"
        tasarim.anaSayfaFragemnt = this

        (activity as AppCompatActivity).setSupportActionBar(tasarim.toolbar)

        var isler = ArrayList<İsler>()
        isler.add(İsler(1,"Yapılcak daha çok iş var"))
        isler.add(İsler(2,"Çok fazla Çok Yapılcak daha çok iş var"))
        isler.add(İsler(3,"Yapılcak daha çok iş var"))
        isler.add(İsler(4,"Yapılcak daha çok iş var"))
        isler.add(İsler(5,"Yapılcak daha çok iş var"))
        yapilacakIslerAdapter = YapilacakİslerAdapter(requireContext(), isler)
        tasarim.yapilacakislerAdapter = yapilacakIslerAdapter
        return tasarim.root
    }


    fun kayitSayfasi() {

        var direction = AnaSayfaFragmentDirections.anaSayfaToKayit();
        Navigation.findNavController(tasarim.root).navigate(direction)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
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
      return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        Log.e("Arama harf girdikce",newText)

        return true
    }
}


