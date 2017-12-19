package com.fotomama.mneumann.fotomama

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.fotomama.mneumann.fotomama.Adapter.MainCardRecyclerAdapter
import com.fotomama.mneumann.fotomama.Entities.MainCard
import kotlinx.android.synthetic.main.activity_main.*
import android.R.menu
import android.content.Intent
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.fotomama.mneumann.fotomama.Activities.ProfileActivity
import com.fotomama.mneumann.fotomama.Activities.SearchActivity
import com.fotomama.mneumann.fotomama.R.id.recyclerView


class MainActivity : AppCompatActivity() {

    private var mainCardsList: ArrayList<MainCard> = ArrayList()
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: MainCardRecyclerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager
        adapter = MainCardRecyclerAdapter(mainCardsList )
        recyclerView.adapter = adapter
    }

    override fun onStart() {
        super.onStart()
        if(mainCardsList.size == 0){
            mainCardsList.add(requestCard())
            var mainCardTwo = MainCard();
            mainCardTwo.photoId = R.drawable.bremen_teerhof
            mainCardsList.add(mainCardTwo)

        }
    }

   override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main, menu)
        return true
    }

    private fun requestCard() : MainCard {
        var mainCard = MainCard()
        return mainCard;
    }

    override  fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        when (item.getItemId()) {
            R.id.search -> {
                val changePage = Intent(this, SearchActivity::class.java)
                startActivity(changePage)
                return true;
            }
            R.id.profile -> {
                val changePage = Intent(this , ProfileActivity::class.java)
                startActivity(changePage)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}
