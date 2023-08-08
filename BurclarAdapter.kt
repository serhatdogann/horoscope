package com.burclarapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class BurclarAdapter(
  var  gelenContext: Context,
    resource: Int,
    textViewResourceId: Int,
   var burcAdi: Array<String>,
   var burcTarihleri:Array<String>,
   var burcResimleri:Array<Int>
) : ArrayAdapter<String>(gelenContext, resource, textViewResourceId, burcAdi) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var inflater = LayoutInflater.from(gelenContext) // Burada context yerine this kullanabilirsiniz
        var tek_Satir_view=inflater.inflate(R.layout.tek_satir,parent,false)
        var burcImageView: ImageView = tek_Satir_view.findViewById(R.id.burcGorsel)
        var burcAdiTextView:TextView=tek_Satir_view.findViewById(R.id.txtBurcAdi)
        var burcTarihleriText:TextView=tek_Satir_view.findViewById(R.id.txtBurcTarih)


        burcImageView.setImageResource(burcResimleri[position])
        burcAdiTextView.setText(burcAdi[position])
        burcTarihleriText.setText(burcTarihleri[position])


        return tek_Satir_view
    }

}


