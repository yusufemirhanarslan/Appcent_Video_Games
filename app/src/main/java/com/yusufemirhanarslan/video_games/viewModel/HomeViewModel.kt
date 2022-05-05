package com.yusufemirhanarslan.video_games.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yusufemirhanarslan.video_games.model.Game
import com.yusufemirhanarslan.video_games.model.Result
import com.yusufemirhanarslan.video_games.service.RetrofitManager
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class HomeViewModel:ViewModel() {

   private  val _gameListLiveData = MutableLiveData<List<Result>>()
   val gameListLiveData : LiveData<List<Result>> = _gameListLiveData
   private val  _errorRequest = MutableLiveData<Throwable>()
    val errorRequest : LiveData<Throwable> = _errorRequest

   fun getGameList(){
       val observer = object : Observer<Game> {
           override fun onSubscribe(d: Disposable) {
           }

           override fun onNext(t: Game) {
              if(t.results!!.isNotEmpty())
                   _gameListLiveData.value = t.results!!


           }

           override fun onError(e: Throwable) {
               _errorRequest.value = e
           }

           override fun onComplete() {
           }

       }
       RetrofitManager
           .getRetrofit()
           .getListGame()
           .subscribeOn(Schedulers.io())
           .observeOn(AndroidSchedulers.mainThread())
           .subscribe(observer)
   }
}