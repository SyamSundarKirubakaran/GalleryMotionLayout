package com.bugscript.gallerymotionlayout.model

object dummyData{

    fun inflateData() : ArrayList<imageData>{
        val sampleImages : ArrayList<imageData>  =
                arrayListOf(
                    imageData(0, "https://image.tmdb.org/t/p/w780/4PiiNGXj1KENTmCBHeN6Mskj2Fq.jpg"),
                    imageData(1, "https://image.tmdb.org/t/p/w780/4PiiNGXj1KENTmCBHeN6Mskj2Fq.jpg"),
                    imageData(2, "https://image.tmdb.org/t/p/w780/4PiiNGXj1KENTmCBHeN6Mskj2Fq.jpg"),
                    imageData(3, "https://image.tmdb.org/t/p/w780/4PiiNGXj1KENTmCBHeN6Mskj2Fq.jpg"),
                    imageData(4, "https://image.tmdb.org/t/p/w780/4PiiNGXj1KENTmCBHeN6Mskj2Fq.jpg")
                )
        return sampleImages
    }

}