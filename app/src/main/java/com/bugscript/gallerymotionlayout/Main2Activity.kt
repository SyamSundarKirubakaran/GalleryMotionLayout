package com.bugscript.gallerymotionlayout

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bugscript.gallerymotionlayout.R.id.imageView
import android.graphics.Bitmap
import com.bumptech.glide.request.target.SimpleTarget
import android.R.attr.path
import android.os.Build
import android.support.v4.content.ContextCompat
import android.support.v7.graphics.Palette
import android.transition.TransitionInflater
import android.widget.ImageView
import com.bugscript.gallerymotionlayout.elasticDismiss.ElasticDragDismissCallback
import com.bugscript.gallerymotionlayout.elasticDismiss.ElasticDragDismissLinearLayout
import com.bugscript.gallerymotionlayout.elasticDismiss.SystemChromeFader
import com.bumptech.glide.request.transition.Transition
import kotlinx.android.synthetic.main.activity_main2.*


class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val bundle = intent.extras
        val imageUrl = bundle?.get("IMAGE").toString()

//        Picasso.get()
//            .load(imageUrl)
//            .placeholder(R.drawable.furlenco_gray_holder)
//            .error(R.drawable.bed)
//            .into(object: com.squareup.picasso.Target {
//                override fun onBitmapFailed(e: java.lang.Exception?, errorDrawable: Drawable?) {
//
//                }
//
//                override fun onPrepareLoad(placeHolderDrawable: Drawable?) {
//
//                }
//
//                override fun onBitmapLoaded(bitmap: Bitmap?, from: Picasso.LoadedFrom?) {
//                    myZoomageView.setImageBitmap(bitmap)
//                    Palette.from(bitmap!!).generate { palette ->
//                        val vibrantSwatch = palette?.mutedSwatch
//                        with(findViewById<ImageView>(R.id.myZoomageView)) {
//                            setBackgroundColor(vibrantSwatch?.rgb ?:
//                            ContextCompat.getColor(context, R.color.colorPrimary))
//                        }
//                    }
//                }
//            })

        Glide.with(this)
            .asBitmap()
            .load(imageUrl)
            .into(object : SimpleTarget<Bitmap>() {
                override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                    myZoomageView.setImageBitmap(resource)
                    Palette.from(resource).generate { palette ->
                        val vibrantSwatch = palette?.mutedSwatch
                        with(findViewById<ImageView>(R.id.myZoomageView)) {
                            setBackgroundColor(vibrantSwatch?.rgb ?:
                            ContextCompat.getColor(context, R.color.colorPrimary))
                        }
                    }
                }
            })
    }
}
