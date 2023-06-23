package com.first.filmleruygulamasi

import android.annotation.SuppressLint

class KatagorilerDao {
    @SuppressLint("Range")
    fun tumKatagoriler(vt:VeritabaniYardimcisi):ArrayList<Katagoriler>{
        val db=vt.readableDatabase
        val katagorilerListe=ArrayList<Katagoriler>()
        val c=db.rawQuery("SELECT * FROM kategoriler",null)
        while (c.moveToNext()){

            val katagori=Katagoriler(c.getInt(c.getColumnIndex("kategori_id")),
                c.getString(c.getColumnIndex("kategori_ad")))
            katagorilerListe.add(katagori)
        }
        return katagorilerListe
    }
}