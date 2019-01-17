package com.bugscript.gallerymotionlayout

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.bugscript.gallerymotionlayout.R.id.imageList
import com.bugscript.gallerymotionlayout.adapter.ImageAdapter
import com.bugscript.gallerymotionlayout.model.dummyData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var imageAdapter: ImageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageAdapter = ImageAdapter(this, dummyData.inflateData()){ image ->
            startActivity(Intent(this,Main2Activity::class.java).putExtra("IMAGE",image.url))
        }
        imageList.adapter = imageAdapter
        val layoutManager = LinearLayoutManager(this)
        imageList.layoutManager = layoutManager

    }
}
