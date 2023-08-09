package com.burclarapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder as ViewHolder

class  BurclarBaseAdapter(context: Context,tumBurcBilgileri:ArrayList<Burc>) :BaseAdapter(){

    var tumburclar:ArrayList<Burc>
    var context:Context

    init {
        this.tumburclar=tumBurcBilgileri
        this.context=context



    }

    override fun getCount(): Int {
    return tumburclar.size
    }

    override fun getItem(position: Int): Any {
        return  tumburclar.get(position)

    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var tek_satir_view = convertView
        var viewHolder: BurclarBaseAdapter.viewHolder

        if (tek_satir_view == null) {
            val inflater = LayoutInflater.from(context)
            tek_satir_view = inflater.inflate(R.layout.tek_satir, parent, false)
            viewHolder = BurclarBaseAdapter.viewHolder(tek_satir_view)
            tek_satir_view.tag = viewHolder  // viewHolder'ı görünümün tag'ine kaydet
        } else {
            viewHolder = tek_satir_view.tag as BurclarBaseAdapter.viewHolder
        }

        val burcGörsel = viewHolder.burcResimleri
        val adi = viewHolder.burcAdi
        val tarih = viewHolder.burcTarih

        val currentBurc = tumburclar[position]
        burcGörsel.setImageResource(currentBurc.burcResimleri)
        adi.text = currentBurc.burcAdi
        tarih.text = currentBurc.burcTarih

        return tek_satir_view
    }



    class viewHolder(tek_satir_view:View){

        var burcAdi:TextView=tek_satir_view.findViewById(R.id.txtBurcAdi)
        var burcResimleri:ImageView=tek_satir_view.findViewById(R.id.imgBurcSembol)
        var burcTarih:TextView=tek_satir_view.findViewById(R.id.txtBurcTarih)

    }
}