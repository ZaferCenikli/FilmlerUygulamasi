package com.first.filmleruygulamasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.info.sqlitekullanimihazirveritabani.DatabaseCopyHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var katagoriList:ArrayList<Katagoriler>
    private lateinit var Zaferadapter:KatagoriAdapter
    private lateinit var vt:VeritabaniYardimcisi



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        veritabaniKopyala()
        setContentView(R.layout.activity_main)
        toolbar.title="Katagoriler"
        setSupportActionBar(toolbar)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager=LinearLayoutManager(this@MainActivity)

        vt= VeritabaniYardimcisi(this)
       katagoriList=KatagorilerDao().tumKatagoriler(vt)

        Zaferadapter= KatagoriAdapter(this@MainActivity,katagoriList)
        recyclerView.adapter=Zaferadapter


    }
    fun veritabaniKopyala(){
        val copyHelper=DatabaseCopyHelper(this@MainActivity)

        try {copyHelper.createDataBase()
            copyHelper.openDataBase()

        }catch (e:Error){
            e.printStackTrace()
        }
    }
}