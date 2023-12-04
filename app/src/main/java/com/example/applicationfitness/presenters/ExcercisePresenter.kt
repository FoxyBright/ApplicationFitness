package com.example.applicationfitness.presenters

import com.example.applicationfitness.contracts.ExcerciseContract
import com.example.applicationfitness.data.ExcerciseRepository
import org.koin.java.KoinJavaComponent.get

class ExcercisePresenter(
    eView: ExcerciseContract.ExcerciseView,
): ExcerciseContract.ExcercisePresenter {
    
    private val excerciseRepository =
        get<ExcerciseRepository>(ExcerciseRepository::class.java)
    
    override fun getExcerciseList() =
        excerciseRepository.getExcerciseList()
}