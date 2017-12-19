package com.fotomama.mneumann.fotomama.Adapter

import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.view.ViewGroup
import com.fotomama.mneumann.fotomama.Activities.SearchActivity
import com.fotomama.mneumann.fotomama.Entities.MainCard
import com.fotomama.mneumann.fotomama.MainActivity
import com.fotomama.mneumann.fotomama.R
import kotlinx.android.synthetic.main.main_card_item_row.view.*

/**
 * Created by mneumann on 12.10.2017.
 */

class MainCardRecyclerAdapter(private val mainCards: ArrayList<MainCard>)  : RecyclerView.Adapter<MainCardRecyclerAdapter.MainCardHolder>(){


    override fun onBindViewHolder(holder: MainCardRecyclerAdapter.MainCardHolder, position: Int) {
        val itemPhoto = mainCards[position]
        if ((position %2) == 0) {
            holder.bindPhoto(itemPhoto)
        } else {
            holder.bindPhotoTwo(itemPhoto)
        }

    }

    override fun getItemCount(): Int {
        return mainCards.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainCardRecyclerAdapter.MainCardHolder {
        val inflatedView = parent.inflate(R.layout.main_card_item_row, false)
        return MainCardHolder(inflatedView)
    }

    class MainCardHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {
        private var view: View = v

        private var mainCard: MainCard ? = null

        init {
            v.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            val context = itemView.context
            if(view.mainCardImageHeadline.text == "Suche"){
                val changePage = Intent(view.context, SearchActivity::class.java)
                return context.startActivity(changePage)
            }
           // val showPhotoIntent = Intent(context, MainActivity::class.java)
         //   showPhotoIntent.putExtra(PHOTO_KEY,mainCard )
          //  context.startActivity(showPhotoIntent)
        }

        fun bindPhoto(mainCard: MainCard) {
            this.mainCard = mainCard
            view.mainCardImageHeadline.text ="Suche"
            view.mainCardImage.setImageResource(R.drawable.bremen_bahnhof)
        }

        fun bindPhotoTwo(mainCard: MainCard) {
            this.mainCard = mainCard
            view.mainCardImageHeadline.text ="Anbieten"
            view.mainCardImage.setImageResource(R.drawable.bremen_teerhof)
        }

        companion object {
            private val PHOTO_KEY = "PHOTO"
        }
    }
}