package com.musicplayeryusriizal

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

import com.musicplayeryusriizal.PlaySongActivity
import com.musicplayeryusriizal.MainAdapter.MyViewHolder
//import kotlin.android.synthetic.main.list_item_main.view.*
import java.util.*

class MainAdapter(var songList: ArrayList<HashMap<String, String>>, var context: Context) : RecyclerView.Adapter<MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_main, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val song = songList[position]
        holder.textView.text = song["songTitle"]?.replace("_", " ")
        holder.cvListMusic.setOnClickListener {
            val intent = Intent(context, PlaySongActivity::class.java)
            intent.putExtra("songIndex", song)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return songList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var cvListMusic: CardView
        var textView: TextView

        init {
            cvListMusic = itemView.findViewById(R.id.cvListMusic)
            textView = itemView.findViewById(R.id.tvJudulLagu)
        }
    }

}