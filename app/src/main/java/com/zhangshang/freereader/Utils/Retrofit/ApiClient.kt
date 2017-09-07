package com.zhangshang.freereader.Utils.Retrofit

import com.zhangshang.freereader.BuildConfig
import com.zhangshang.freereader.MyApplication
import com.zhangshang.novelreader.NetworkDetector
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by allenlucas on 17-8-29.
 */
object ApiClient {

    fun retrofit():ApiStores{
        val builder = OkHttpClient.Builder()
        val cacheINtercepter = Interceptor{
            chain: Interceptor.Chain? ->
            var request = chain!!.request()
            if (!NetworkDetector().detector(MyApplication)){
                request = request.newBuilder()
                        .cacheControl(CacheControl.FORCE_CACHE)
                        .build()
            }
            var response = chain.proceed(request)
            if (NetworkDetector().detector(MyApplication)){
                val maxAge = 0
                response.newBuilder().header("Cache-Control", "public, max-age=" + maxAge)
                        .removeHeader("netCache")
                        .build()
            }else{
                val maxStale = 60 * 60 * 24 * 28
                response.newBuilder()
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                        .removeHeader("nyn")
                        .build()
            }
            return@Interceptor response
        }
        if (BuildConfig.DEBUG){
            val loggingINterceptor = HttpLoggingInterceptor()
            loggingINterceptor.level = HttpLoggingInterceptor.Level.BODY
            builder.addInterceptor(loggingINterceptor)
        }
        val okhttpClient = builder.build()
        val retrofit = Retrofit.Builder()
                .baseUrl(ApiStores.API_SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okhttpClient)
                .build()
        return retrofit.create(ApiStores::class.java)
    }
}