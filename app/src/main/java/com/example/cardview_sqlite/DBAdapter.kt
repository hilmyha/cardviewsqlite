package com.example.cardview_sqlite

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DBAdapter(private val listDataku: ArrayList<DBModel>): RecyclerView.Adapter<DBAdapter.CardViewHolder>() {
    inner class CardViewHolder(itemV: View): RecyclerView.ViewHolder(itemV) {
        var tvemailku: TextView = itemV.findViewById(R.id.tv_emailku)
        var tvpassku: TextView = itemV.findViewById(R.id.tv_passku)
        var tvakunku: TextView = itemV.findViewById(R.id.tv_akunku)
        var tvnamaku: TextView = itemV.findViewById(R.id.tv_namaku)
        var btndelete: Button = itemV.findViewById(R.id.btn_deletecard)
        var btnupdate: Button = itemV.findViewById(R.id.btn_updatecard)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_dataku, parent, false)
        return CardViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listDataku.size
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val dataku = listDataku[position]
        holder.tvemailku.text = dataku.email
        holder.tvpassku.text = dataku.pass
        holder.tvakunku.text = dataku.username
        holder.tvnamaku.text = dataku.fullname

        holder.btndelete.setOnClickListener {
            var adapterDBHelper: DBHelper
            adapterDBHelper = DBHelper(holder.itemView.context)
            adapterDBHelper.deleteData(dataku.email)
            listDataku.removeAt(position)
            notifyDataSetChanged()
        }

        holder.btnupdate.setOnClickListener {
            val pindahUpdAc = Intent(holder.itemView.context, UpdateActivity::class.java)
            val bundle = Bundle()
            bundle.putString("emailk", dataku.email)
            bundle.putString("usernamek", dataku.username)
            bundle.putString("fullnamek", dataku.fullname)
            bundle.putString("passk", dataku.pass)
            pindahUpdAc.putExtras(bundle)
            holder.itemView.context.startActivity(pindahUpdAc)
        }
    }
}