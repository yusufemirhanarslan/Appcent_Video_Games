package com.yusufemirhanarslan.video_games.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.SearchView.OnQueryTextListener
import com.bumptech.glide.Glide
import com.yusufemirhanarslan.video_games.R
import kotlinx.android.synthetic.main.fragment_detail_page.*
import kotlinx.android.synthetic.main.fragment_home_page.*
import kotlinx.android.synthetic.main.vide_list_design.view.*

class DetailPage : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {

            val gameName = DetailPageArgs.fromBundle(it).videoGameName
            val gameReleased = DetailPageArgs.fromBundle(it).videoGamesRating
            val gameImage = DetailPageArgs.fromBundle(it).videoGamePhoto
            val gameMetacritic = DetailPageArgs.fromBundle(it).videoGameMetacriticRate

            gameNameDetailTextView.text = gameName
            gameReleaseDateTextView.text = "Game Released: "+gameReleased
            Glide.with(this).load(gameImage).into(gameDetailImage)
            gameMetacriticRateTextView.text = "Game Metacritic: " + gameMetacritic.toInt()


        }

        favoriteButton.setOnClickListener {

            favoriteButton.setImageResource(R.drawable.ic_red_favorite_full)

        }




    }

}