package com.example.recycler_view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var rvNames: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }

    override fun  onResume() {
        super.onResume()
        rvNames = findViewById(R.id.rvnames)
        val names = listOf("Anne","Andrew","Ruby","James","Rebeccah","Umutoni","Angela","Daniella","Thomas", "Linn","Shaline","Berissa")
        val namesAdapter = NamesRvAdapter(names)
        rvNames.layoutManager= LinearLayoutManager(this)
        rvNames.layoutManager = GridLayoutManager(this, 3)
        rvNames.adapter = namesAdapter


    }
}