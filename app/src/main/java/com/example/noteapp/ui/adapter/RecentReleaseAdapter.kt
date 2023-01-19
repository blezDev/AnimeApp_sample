package com.example.noteapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.noteapp.R
import com.example.noteapp.data.RecentReleaseDataItem
import com.example.noteapp.databinding.AnimeImgListBinding

class RecentReleaseAdapter(val context : Context) : PagingDataAdapter<RecentReleaseDataItem,RecentReleaseAdapter.ItemHolder>(
    COMPARATOR) {
    private lateinit var binding :AnimeImgListBinding


    inner class ItemHolder(binding :AnimeImgListBinding) : RecyclerView.ViewHolder(binding.root)



    companion object{
        private val COMPARATOR = object : DiffUtil.ItemCallback<RecentReleaseDataItem>(){
            override fun areItemsTheSame(
                oldItem: RecentReleaseDataItem,
                newItem: RecentReleaseDataItem
            ): Boolean {
               return oldItem.animeId == newItem.animeId
            }

            override fun areContentsTheSame(
                oldItem: RecentReleaseDataItem,
                newItem: RecentReleaseDataItem
            ): Boolean {
               return  oldItem== newItem
            }

        }
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.setIsRecyclable(false)
        val item = getItem(position)
       binding.AnimeName.text = item?.animeTitle
        Glide.with(context).load(item?.animeImg).into(binding.recentImageView)
        binding.episodeText.text = item?.episodeNum

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.anime_img_list,parent,false)
        return ItemHolder(binding)
    }

}