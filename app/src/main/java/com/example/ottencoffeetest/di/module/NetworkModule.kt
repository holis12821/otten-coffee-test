package com.example.ottencoffeetest.di.module

import com.example.ottencoffeetest.model.remote.ProductService
import com.example.ottencoffeetest.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * @Module informs Dagger hilt that this class is a Dagger Module*/
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    /**
     * @Singleton inform Dagger hilt only one have intance to object
     * @Provides tell Dagger hilt how to create instance of  the type that this function
     * return (i.e. ProductService).
     * Function parameters are that dependencies of this type.*/

    @Singleton
    @Provides
    fun provideHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofitService(okHttpClient: OkHttpClient): Retrofit {
        //Whenever Dagger hilt needs to provide an instance of type ProductService,
        //this code (the one inside the @Provides method) is run.
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesProductAPI(retrofit: Retrofit): ProductService =
        retrofit.create(ProductService::class.java)

}