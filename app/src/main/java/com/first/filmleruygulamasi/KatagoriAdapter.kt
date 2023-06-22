package com.first.filmleruygulamasi

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.card_katagori.view.*
import java.util.zip.Inflater

class KatagoriAdapter(private val mContext: Context,private val katagoriListe:List<Katagoriler>)
    :RecyclerView.Adapter<KatagoriAdapter.cartTasarimTutucu>() {
    inner class cartTasarimTutucu(tasarim:View):RecyclerView.ViewHolder(tasarim){
        var card_katagori:CardView
        var textViewKatagori:TextView

        init {
            card_katagori=tasarim.findViewById(R.id.card_katagori)
            textViewKatagori=tasarim.findViewById(R.id.textViewKatagori)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cartTasarimTutucu {
        val tasarim2=LayoutInflater.from(mContext).inflate(R.layout.card_katagori,parent,false)
        return cartTasarimTutucu(tasarim2)

    }

    override fun getItemCount(): Int {
     return   katagoriListe.size
    }

    override fun onBindViewHolder(holder: cartTasarimTutucu, position: Int) {
        val asdqwe=katagoriListe.get(position)
        holder.textViewKatagori.text=asdqwe.katagori_ad
        holder.card_katagori.setOnClickListener{
            var ıntent=Intent(mContext,FilmlerActivity::class.java)
            ıntent.putExtra("katagoriNesne",asdqwe)
            mContext.startActivity(ıntent)

        }



    }
}