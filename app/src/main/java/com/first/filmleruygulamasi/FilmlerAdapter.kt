package com.first.filmleruygulamasi

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import java.util.Locale.FilteringMode

class FilmlerAdapter(private val mContext:Context,private val filmlerListe:List<Filmler>):RecyclerView.Adapter<FilmlerAdapter.cartTasarimTutucu>() {

    inner class cartTasarimTutucu(tasarim: View): RecyclerView.ViewHolder(tasarim){
        var cardViewFilmler: CardView
        var textViewFilmAd: TextView
        var imageViewFilmResim:ImageView

        init {
            cardViewFilmler=tasarim.findViewById(R.id.cardViewFilmler)
            textViewFilmAd=tasarim.findViewById(R.id.textViewFilmAd)
            imageViewFilmResim=tasarim.findViewById(R.id.imageViewFilmResim)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cartTasarimTutucu {
        val tasarim2= LayoutInflater.from(mContext).inflate(R.layout.filmler_card_tasarim,parent,false)
        return cartTasarimTutucu(tasarim2)

    }

    override fun getItemCount(): Int {
        return   filmlerListe.size
    }

    override fun onBindViewHolder(holder: cartTasarimTutucu, position: Int) {
        val asdqwe=filmlerListe.get(position)
        holder.textViewFilmAd.text=asdqwe.film_ad
        holder.imageViewFilmResim.setImageResource(mContext.resources.getIdentifier
            (asdqwe.film_resim,"drawable",mContext.packageName))
        holder.cardViewFilmler.setOnClickListener{
            var ıntent= Intent(mContext,DetayActivity::class.java)
            ıntent.putExtra("filmNesne",asdqwe)
            mContext.startActivity(ıntent)

        }



    }
}