package com.burclarapp

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.palette.graphics.Palette
import com.google.android.material.appbar.CollapsingToolbarLayout
import org.w3c.dom.Text

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        var positions = intent.extras?.getInt("tıklananOgePositions") as Int
        var tumBurcBilgileri=intent.extras?.get("tumBurcBilgileri") as ArrayList<Burc>

        val BurcOzellikleri=findViewById<TextView>(R.id.BurcOzellikleritext)
        BurcOzellikleri.setText(tumBurcBilgileri.get(positions).burcGenelOzellikleri)
        var header=findViewById<ImageView>(R.id.header)
        header.setImageResource(tumBurcBilgileri.get(positions).burcBuyukResim)

        val anim_toolbar=findViewById<Toolbar>(R.id.anim_toolbar)
        setSupportActionBar(anim_toolbar)

       var collapsingToolbar =findViewById<CollapsingToolbarLayout>(R.id.collapsing_toolbar);
        collapsingToolbar.title=tumBurcBilgileri.get(positions).burcAdi


        var bitmap= BitmapFactory.decodeResource(resources, tumBurcBilgileri.get(positions).burcBuyukResim)

        Palette.from(bitmap).generate(object : Palette.PaletteAsyncListener{
            override fun onGenerated(palette: Palette?) {

                var color=palette?.getVibrantColor(androidx.appcompat.R.attr.colorAccent)
                collapsingToolbar.setContentScrimColor(color!!)

                window.statusBarColor=color

            }


        })

            }
}