package com.yusufemirhanarslan.video_games.service

import com.yusufemirhanarslan.video_games.model.Game
import retrofit2.http.GET
import io.reactivex.Observable

interface GameAPI {


    //API Server URL =  https://api.rawg.io/api/
    //platforms?key=c94532785a7f44b5920d1800977f34aa

/*
    @GET("platforms?key=c94532785a7f44b5920d1800977f34aa")
    fun getListGame(): Observable<Game>

*/


    @GET("games?key=c94532785a7f44b5920d1800977f34aa&dates=2019-09-01,2019-09-30&platforms=18,1,7")
    fun getListGame(): Observable<Game>

    //https://api.rawg.io/api/
   // games?key=c94532785a7f44b5920d1800977f34aa&dates=2019-09-01,2019-09-30&platforms=18,1,7

}