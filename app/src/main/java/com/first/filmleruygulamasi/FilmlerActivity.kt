package com.first.filmleruygulamasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_filmler.*
import kotlinx.android.synthetic.main.activity_main.*

class FilmlerActivity : AppCompatActivity() {
    private lateinit var FilmlerList:ArrayList<Filmler>
    private lateinit var Adapter:FilmlerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filmler)

        val katagori=intent.getSerializableExtra("katagoriNesne")as Katagoriler

        toolbarFilmler.title="Filmler${katagori.katagori_ad}"
        setSupportActionBar(toolbarFilmler)

        recViewFilmler.setHasFixedSize(true)
        recViewFilmler.layoutManager=StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)

        FilmlerList= ArrayList()

        val k=Katagoriler(1,"KOMEDİ")
        val y=Yonetmenler(1,"Zafer")

        val f1=Filmler(1,"Django",2008,"django",k,y)
        val f2=Filmler(2,"Inception",2009,"inception",k,y)
        val f3=Filmler(3,"ThePianist",2010,"thepianist",k,y)
        FilmlerList.add(f1)
        FilmlerList.add(f2)
        FilmlerList.add(f3)

        Adapter=FilmlerAdapter(this@FilmlerActivity,FilmlerList)
        recViewFilmler.adapter=Adapter




    }
}