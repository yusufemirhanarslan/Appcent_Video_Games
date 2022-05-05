package com.yusufemirhanarslan.video_games.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yusufemirhanarslan.video_games.R
import com.yusufemirhanarslan.video_games.model.Game
import com.yusufemirhanarslan.video_games.model.Result
import com.yusufemirhanarslan.video_games.view.HomePageDirections
import kotlinx.android.synthetic.main.vide_list_design.view.*


class GameRecyclerAdapter(var gameList: List<Result>,private val listener: Listener) : RecyclerView.Adapter<GameRecyclerAdapter.RowHolder>(){



    interface Listener{
        fun onItemClick(gameDetail: Result)

    }

    class RowHolder(view : View) : RecyclerView.ViewHolder(view){
        fun bind(gameDetail: Result,position: Int,listener : Listener){

            itemView.setOnClickListener {
                listener.onItemClick(gameDetail)
            }
            Glide.with(itemView.context).load(gameDetail.background_image).into(itemView.gameImage)
            itemView.gameNameText.text = gameDetail.name.toString()
            itemView.gameRatingText.text = "Games Rating: " + gameDetail.rating
            itemView.gameReleasedText.text = "Game Released: " + gameDetail.released
           }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.vide_list_design,parent,false)
        return RowHolder(view)
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {
        holder.bind(gameList[position],position,listener)

        holder.itemView.setOnClickListener { p0 ->
            val action = HomePageDirections.actionHomePageToDetailPage(
                gameList[position].name.toString(),
                gameList[position].released.toString(),
                gameList[position].background_image.toString(),
                gameList[position].metacritic.toString()
            )
            if (p0 != null) {
                Navigation.findNavController(p0).navigate(action)
            }
        }
    }

    override fun getItemCount(): Int {
        return gameList.count()
    }


}