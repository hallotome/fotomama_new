package com.fotomama.mneumann.fotomama.Activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import com.fotomama.mneumann.fotomama.Entities.MainCard
import com.fotomama.mneumann.fotomama.R

/**
 * A login screen that offers login via email/password.
 */
class SearchActivity : AppCompatActivity() {
    /**
     * Keep track of the login task to ensure we can cancel it if requested.
     */



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.search_formular)
        setTitle(R.string.title_search_activity)
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

    /** Called when the user touches the button  */
    fun searchForFotograph(view: View) {
        val changePage = Intent(this, SearchResultActivity::class.java)
        startActivity(changePage)
    }

    override  fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        when (item.getItemId()) {
            R.id.search -> {
                val changePage = Intent(this, SearchActivity::class.java)
                startActivity(changePage)
                return true;
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

}
