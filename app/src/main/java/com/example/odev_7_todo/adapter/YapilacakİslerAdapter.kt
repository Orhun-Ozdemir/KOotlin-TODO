package com.example.odev_7_todo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.odev_7_todo.databinding.RecycleviewCardItemBinding
import com.example.odev_7_todo.fragment.AnaSayfaFragmentDirections
import com.example.odev_7_todo.İsler

class YapilacakİslerAdapter(var mContext: Context, var dataSet:List<İsler>):RecyclerView.Adapter<YapilacakİslerAdapter.CardViewHolder>(){





    inner class CardViewHolder(tasarim:RecycleviewCardItemBinding):RecyclerView.ViewHolder(tasarim.root)
    {
    val tasarim:RecycleviewCardItemBinding
        init {
           this.tasarim=tasarim
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val inflator=LayoutInflater.from(mContext)
        val tasarim=RecycleviewCardItemBinding.inflate(inflator,parent,false)
        return CardViewHolder(tasarim)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int)
    {

        holder.tasarim.yapilacaklar=dataSet[position]

        holder.tasarim.cardYapilacakIs.setOnClickListener {

            val directions=AnaSayfaFragmentDirections.anaSayfaToDetay(dataSet[position])
            Navigation.findNavController(it).navigate(directions)

        }
        holder.tasarim.imageViewDelete.setOnClickListener {




        }


    }

    override fun getItemCount(): Int {
       return dataSet.size
    }
}