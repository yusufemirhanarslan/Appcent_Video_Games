package com.yusufemirhanarslan.video_games.service

import com.yusufemirhanarslan.video_games.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitManager {

    companion object {
        private const val REQUEST_TIMEOUT = 20L
        private var client: OkHttpClient? = null
        private val BASE_URL = "https://api.rawg.io/api/"
        fun getRetrofit(): GameAPI {
            var retrofit: Retrofit? = null
            if (retrofit == null) {
                val okHttpBuilder = OkHttpClient().newBuilder()
                    .connectTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
                    .readTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)

                if (BuildConfig.DEBUG) {
                    val interceptor = HttpLoggingInterceptor()
                    interceptor.apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    }
                    okHttpBuilder.addInterceptor(interceptor)
                }
                client = okHttpBuilder.build()
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build()
                return retrofit.create(GameAPI::class.java)
            } else {
                return retrofit.create(GameAPI::class.java)
            }
        }
    }
}