package com.first.filmleruygulamasi

data class Filmler(var film_id:Int,var film_ad:String,var film_yil:Int,
                   var film_resim:String,var katagori: Katagoriler ,var yonetmen: Yonetmenler):java.io.Serializable {
}