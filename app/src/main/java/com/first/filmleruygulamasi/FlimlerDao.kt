package com.first.filmleruygulamasi

import android.annotation.SuppressLint

class FlimlerDao {
    @SuppressLint("Range")
    fun tumFilmler(vt:VeritabaniYardimcisi,katagori_id:Int):ArrayList<Filmler>{
        val db=vt.readableDatabase
        val filmlerListe=ArrayList<Filmler>()
        val c=db.rawQuery("SELECT * FROM kategoriler,yonetmenler,filmler WHERE filmler.kategori_id=kategoriler.kategori_id AND filmler.yonetmen_id=yonetmenler\t.yonetmen_id AND filmler.kategori_id=$katagori_id",null)
        while (c.moveToNext()){

            val katagori=Katagoriler(c.getInt(c.getColumnIndex("kategori_id")),
                c.getString(c.getColumnIndex("kategori_ad")))

            val yonetmen=Yonetmenler(c.getInt(c.getColumnIndex("yonetmen_id")),
                c.getString(c.getColumnIndex("yonetmen_ad")))

            val filmler=Filmler(c.getInt(c.getColumnIndex("film_id")),
                c.getString(c.getColumnIndex("film_ad")),
                c.getInt(c.getColumnIndex("film_yil")),
                c.getString(c.getColumnIndex("film_resim")), katagori,yonetmen)
            filmlerListe.add(filmler)

        }
        return filmlerListe
    }
}