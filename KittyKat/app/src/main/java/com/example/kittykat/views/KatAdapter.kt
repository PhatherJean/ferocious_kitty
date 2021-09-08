package com.example.kittykat.views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kittykat.model.Kat
import com.example.kittykat.databinding.ItemKatBinding
import com.example.kittykat.utils.loadWithGlide

/*
* ListView - loads all object into memory not optimize for dynamic objects more for fixed amount/size
* RecyclerView - Leverage the ViewHolder Pattern to optimize scrolling and memory consumption
* ListAdapter - Same as RecyclerView but we don't have to use the notify methods to update the adapter
* */
class KatAdapter(private val katList: MutableList<Kat> = mutableListOf() ) : RecyclerView.Adapter<KatAdapter.KatViewHolder>()
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : KatViewHolder = KatViewHolder.getInstance(parent)

    override fun onBindViewHolder(holder: KatViewHolder, position: Int)
    {
        holder.loadKat(katList[position])
    }

    override fun getItemCount() = katList.size


    fun updateList(kat: List<Kat>)
    {
        katList.clear()
        katList.addAll(kat)
        notifyDataSetChanged()
    }


    class KatViewHolder(private val binding: ItemKatBinding) : RecyclerView.ViewHolder(binding.root)
    {

        fun loadKat(kat : Kat) = with(binding)
        {
            ivKat.loadWithGlide(kat.url)
        }

        companion object
        {
            fun getInstance(parent: ViewGroup): KatViewHolder {
                val binding = ItemKatBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
                return KatViewHolder(binding)
            }
        }
    }
}
