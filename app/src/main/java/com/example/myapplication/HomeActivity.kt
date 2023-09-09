package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.myapplication.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var rvAdapter: PopAdapter
    private lateinit var dataList:ArrayList<Recip>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setuprcv()
    }

    private fun setuprcv() {
        dataList= ArrayList()
        binding.rvPopular.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        var db=Room.databaseBuilder(this@HomeActivity,AppDatabase::class.java,"db_name")
          .allowMainThreadQueries()
          .fallbackToDestructiveMigration()
          .createFromAsset("recip.db")
          .build()
        var daoObject=db.getDao()
        var recipes=daoObject.getall()
        for(i in recipes!!.indices){
            if(recipes[i]!!.category.contains("Popular")){
                dataList.add(recipes[i]!!)
            }
            rvAdapter=PopAdapter(dataList,this)
            binding.rvPopular.adapter=rvAdapter
        }
    }
}