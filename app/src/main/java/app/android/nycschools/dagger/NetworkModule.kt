package app.android.nycschools.dagger

import app.android.nycschools.network.SatScoresService
import app.android.nycschools.network.SchoolListService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun providesBaseUrl(): String {
        return "https://data.cityofnewyork.us/resource/"
        //ListOfSchools ---> https://data.cityofnewyork.us/resource/s3k6-pzi2.json
        //SatScores ---> https://data.cityofnewyork.us/resource/f9bf-2cp4.json
    }

    @Provides
    fun providesLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    fun providesOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        val okHttpClient = OkHttpClient().newBuilder()
        okHttpClient.addInterceptor(loggingInterceptor)
        okHttpClient.build()
        return okHttpClient.build()
    }

    @Provides
    fun provideConverterFactory(): Converter.Factory {
        return GsonConverterFactory.create()
    }

    @Provides
    fun provideRetrofitClient(okHttpClient: OkHttpClient, baseUrl: String, converterFactory: Converter.Factory): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(converterFactory)
            .build()
    }

    @Provides
    fun provideSchoolListService(retrofit: Retrofit): SchoolListService {
        return retrofit.create(SchoolListService::class.java)
    }

    @Provides
    fun provideSchoolSatScoresService(retrofit: Retrofit): SatScoresService {
        return retrofit.create(SatScoresService::class.java)
    }
}