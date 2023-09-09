package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.GlideBuilder
import com.example.myapplication.databinding.PopularItemBinding


class PopAdapter(var dataList: ArrayList<Recip>,var context: Context):
    RecyclerView.Adapter<PopAdapter.ViewHolder>() {
    inner class ViewHolder(var binding: PopularItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
         var binding=PopularItemBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.popImage
        Glide.with(context).load(dataList.get(position).img).into(holder.binding.popImage)
        var time=dataList.get(position).ing.split("\n".toRegex()).dropLastWhile {it.isEmpty()}.toTypedArray()
        holder.binding.poptext.text=dataList.get(position).tittle
        holder.binding.poptime.text=time.get(0)
    }

}