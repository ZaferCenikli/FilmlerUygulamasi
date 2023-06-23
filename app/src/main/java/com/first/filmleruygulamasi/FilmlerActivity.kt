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
    private lateinit var vt:VeritabaniYardimcisi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filmler)

        val katagori=intent.getSerializableExtra("katagoriNesne")as Katagoriler

        toolbarFilmler.title="Filmler${katagori.katagori_ad}"
        setSupportActionBar(toolbarFilmler)

        recViewFilmler.setHasFixedSize(true)
        recViewFilmler.layoutManager=StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)

        vt= VeritabaniYardimcisi(this)
        FilmlerList=FlimlerDao().tumFilmler(vt,katagori.katagori_id)

        Adapter=FilmlerAdapter(this@FilmlerActivity,FilmlerList)
        recViewFilmler.adapter=Adapter




    }
}