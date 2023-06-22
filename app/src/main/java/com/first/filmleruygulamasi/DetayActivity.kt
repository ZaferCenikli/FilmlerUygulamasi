package com.first.filmleruygulamasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detay.*

class DetayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detay)

       val ıntent=intent.getSerializableExtra("filmNesne")as Filmler

        imageViewDetay.setImageResource(this.resources.getIdentifier(ıntent.film_resim,"drawable",this.packageName))
        textViewFilmAdDetay.text=ıntent.film_ad
        textViewFlimYonetmen.text=ıntent.yonetmen.yonetmen_ad
        textViewFlimYıl.text=ıntent.film_yil.toString()
    }
}