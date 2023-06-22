package com.first.filmleruygulamasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var katagoriList:ArrayList<Katagoriler>
    private lateinit var Zaferadapter:KatagoriAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar.title="Katagoriler"
        setSupportActionBar(toolbar)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager=LinearLayoutManager(this@MainActivity)

        katagoriList=ArrayList()

        val k1=Katagoriler(1,"KOMEDİ")
        val k2=Katagoriler(2,"BİLİM KURGU")
        val k3=Katagoriler(3,"ACTİON")

        katagoriList.add(k1)
        katagoriList.add(k2)
        katagoriList.add(k3)

        Zaferadapter= KatagoriAdapter(this@MainActivity,katagoriList)
        recyclerView.adapter=Zaferadapter


    }
}