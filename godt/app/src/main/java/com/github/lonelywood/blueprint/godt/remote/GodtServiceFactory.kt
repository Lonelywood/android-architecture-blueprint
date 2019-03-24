package com.github.lonelywood.blueprint.godt.remote

import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import timber.log.Timber
import java.util.concurrent.TimeUnit

object GodtServiceFactory {
    fun makeGodtService(isDebug: Boolean): GodtService {
        val okHttpClient = makeOkHttpClient(
            makeLoggingInterceptor(isDebug))
        return makeBufferooService(okHttpClient, makeMoshi())
    }

    private fun makeBufferooService(okHttpClient: OkHttpClient, moshi: Moshi): GodtService {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.godt.no/api/")
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
        return retrofit.create(GodtService::class.java)
    }

    private fun makeOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }

    private fun makeMoshi(): Moshi {
        return Moshi.Builder()
            .build()
    }

    private fun makeLoggingInterceptor(isDebug: Boolean): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor(makeTimberLogger())
        logging.level = if (isDebug)
            HttpLoggingInterceptor.Level.BODY
        else
            HttpLoggingInterceptor.Level.NONE
        return logging
    }

    private fun makeTimberLogger(): HttpLoggingInterceptor.Logger {
        return HttpLoggingInterceptor.Logger {
            Timber.tag("OkHttp").d(it)
        }
    }
}