package com.example.noteapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.noteapp.databinding.ActivityMainBinding
import com.example.noteapp.ui.AnimeViewModel
import com.example.noteapp.ui.adapter.RecentReleaseAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var adapter : RecentReleaseAdapter
    private lateinit var animeViewModel: AnimeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        adapter = RecentReleaseAdapter(this)
        animeViewModel = ViewModelProvider(this)[AnimeViewModel::class.java]
        binding.recyclerView.layoutManager = GridLayoutManager(this,2)
        binding.recyclerView.setHasFixedSize(true)

            CoroutineScope(Dispatchers.Main).launch {
                animeViewModel.list.collectLatest {
                    adapter.submitData(lifecycle,it)
                    binding.recyclerView.adapter = adapter
                }
            }



    }
}