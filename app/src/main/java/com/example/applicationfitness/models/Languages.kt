package com.example.applicationfitness.models

enum class Languages(val value: String) {
    RU("ru"), EN("en");
    
    companion object {
        
        fun getLanguage(locale: String?) = values()
            .find { it.value == locale } ?: RU
    }
}