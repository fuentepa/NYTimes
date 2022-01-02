package com.paf.nytimes.di

import android.app.Application
import com.paf.nytimes.BuildConfig
import com.paf.nytimes.R
import com.paf.nytimes.data.database.ArticleDataBase
import com.paf.nytimes.data.database.RoomDataSource
import com.paf.nytimes.data.repository.ArticlesRepository
import com.paf.nytimes.data.server.TheArticleDb
import com.paf.nytimes.data.server.TheArticleDbDataSource
import com.paf.nytimes.data.source.LocalDataSource
import com.paf.nytimes.data.source.RemoteDataSource
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.core.qualifier.named
import org.koin.dsl.module

fun Application.initDI() {
    startKoin {
        androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
        androidContext(this@initDI)
        modules(listOf(
            appModule,
            retrofitRepositoryModule,
            useCaseModule,
            viewModelModule))
    }
}

val appModule = module {
    single(named("baseUrl")) { "https://api.nytimes.com/svc/mostpopular/v2/" }
    single(named("apiKey")) { androidApplication().getString(R.string.api_key) }
    single { TheArticleDb(get(named("baseUrl"))) }
    single { ArticleDataBase.build(get()) }
    factory<LocalDataSource> { RoomDataSource(get()) }
    factory<RemoteDataSource> { TheArticleDbDataSource(get()) }
}

val retrofitRepositoryModule = module {
    factory { ArticlesRepository(get(), get()) }
}

val useCaseModule = module {

}

val viewModelModule = module {

}