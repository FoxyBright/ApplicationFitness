package com.example.applicationfitness

import android.app.Application
import com.example.applicationfitness.contracts.CartContract
import com.example.applicationfitness.data.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

class FitnessApp: Application() {
    
    private val dataModule = module {
        singleOf(::SharedPrefs)
        singleOf(::ProfileRepository)
        singleOf(::LoginRepository)
        singleOf(::MainRepository)
        singleOf(::FoodRepository)
    }
    
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@FitnessApp)
            modules(listOf(dataModule))
        }
    }
}