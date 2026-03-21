package com.the.marketplace.di

import android.content.Context
import androidx.room.Room
import com.the.marketplace.BuildConfig
import com.the.marketplace.data.db.AppDb
import com.the.marketplace.data.db.CartDao
import com.the.marketplace.data.remote.PixabayApi
import com.the.marketplace.data.repository.CartRepositoryImplem
import com.the.marketplace.data.repository.ProductRepositoryImpl
import com.the.marketplace.domain.repository.CartRepository
import com.the.marketplace.domain.repository.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.PIXABAY_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providePixabayApi(retrofit: Retrofit): PixabayApi {
        return retrofit.create(PixabayApi::class.java)
    }

    @Provides
    @Singleton
    fun provideProductRepository(
        api: PixabayApi
    ): ProductRepository {
        return ProductRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): AppDb{
         return Room.databaseBuilder(
             context,
             AppDb::class.java,
             "image_db",
             ).fallbackToDestructiveMigration()
             .build()
    }

    @Provides
    @Singleton
    fun provideCartDao(db:AppDb):CartDao{
        return db.userDao()
    }

    @Provides
    @Singleton
    fun provideCartRepository(
        dao: CartDao
    ):CartRepository{
        return CartRepositoryImplem(dao)
    }
}
