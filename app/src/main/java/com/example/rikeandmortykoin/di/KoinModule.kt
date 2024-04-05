package com.example.rikeandmortykoin.di

import com.example.rikeandmortykoin.data.CartoonApiService
import com.example.rikeandmortykoin.data.NetworkService
import com.example.rikeandmortykoin.repository.CharacterRepository
import com.example.rikeandmortykoin.repository.CharactersRepository
import com.example.rikeandmortykoin.ui.characters.CharactersViewModel
import com.example.rikeandmortykoin.ui.character.DetailsViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val networkModule = module {
    single { provideInterceptor() }
    single { provideOkHttpClient(get()) }
    single { provideRetrofit(get()) }
    single { provideCartoonApiService(get()) }
}

val repositoryModule = module {
    single { CharactersRepository(get()) }
    single { CharacterRepository(get()) }
}

val viewModelModule = module {
    viewModel<CharactersViewModel> { CharactersViewModel(get()) }
    viewModel<DetailsViewModel> { DetailsViewModel(get()) }
}

val modules =
    listOf(networkModule, repositoryModule, viewModelModule)

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = NetworkService.createRetrofit(okHttpClient)

fun provideOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient = NetworkService.createOkHttpClient(interceptor)

fun provideInterceptor(): HttpLoggingInterceptor = NetworkService.createLoggingInterceptor()

fun provideCartoonApiService(retrofit: Retrofit): CartoonApiService = retrofit.create(
    CartoonApiService::class.java)
