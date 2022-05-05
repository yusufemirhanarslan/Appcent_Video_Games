package com.yusufemirhanarslan.video_games.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.yusufemirhanarslan.video_games.R
import com.yusufemirhanarslan.video_games.adapter.GameRecyclerAdapter
import com.yusufemirhanarslan.video_games.model.Game
import com.yusufemirhanarslan.video_games.model.Result
import com.yusufemirhanarslan.video_games.viewModel.HomeViewModel
import kotlinx.android.synthetic.main.fragment_home_page.*
import kotlin.collections.contains as contains1

class HomePage : Fragment(), GameRecyclerAdapter.Listener {
    private var gameRecyclerAdapter: GameRecyclerAdapter? = null
    private lateinit var viewModel: HomeViewModel
    private lateinit var linearLayoutManager: LinearLayoutManager
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
       viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        return inflater.inflate(R.layout.fragment_home_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        linearLayoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        gameRecyclerAdapter = GameRecyclerAdapter(emptyList<Result>() ,this)
        recyclerView.apply {
            adapter = gameRecyclerAdapter
            setHasFixedSize(true)
            layoutManager = linearLayoutManager
        }

        viewModel.gameListLiveData.observe(viewLifecycleOwner){
            gameRecyclerAdapter!!.gameList = it as ArrayList<Result>
            gameRecyclerAdapter!!.notifyDataSetChanged()
        }
        viewModel.getGameList()



    }


    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onItemClick(gameDetail: Result) {


    }



}