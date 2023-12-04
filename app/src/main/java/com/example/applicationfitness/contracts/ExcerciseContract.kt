package com.example.applicationfitness.contracts

import com.example.applicationfitness.models.ExcerciseModel

interface ExcerciseContract {
    
    interface ExcerciseView {
        
        fun navigateToItem(excercise: ExcerciseModel)
    }
    
    interface ExcercisePresenter {
        
        fun getExcerciseList(): List<ExcerciseModel>
    }
    
    interface ExcerciseRepository {
        
        fun getExcerciseList(): List<ExcerciseModel>
    }
}