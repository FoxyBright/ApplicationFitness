package com.example.applicationfitness.presenters

import com.example.applicationfitness.contracts.CalculatorContract
import com.example.applicationfitness.data.ProfileRepository
import org.koin.java.KoinJavaComponent.get

class CalculatorPresenter(
    private val cView: CalculatorContract.CalculatorView,
): CalculatorContract.CalculatorPresenter {
    
    private val profileRepository =
        get<ProfileRepository>(ProfileRepository::class.java)
    
    override fun calculateCalories(
        weight: String,
        height: String,
        age: String,
        sex: String?,
        active: Long,
        maleString: String,
    ) {
        val dci = sex
            ?.also { profileRepository.setUserSex(it) }
            ?.let { if (it == maleString) 5 else -161 }
            ?: run {
                cView.showToast("Не выбран пол!")
                return
            }
        
        val enteredHeight = height
            .ifEmpty { cView.showToast("Не выбран рост!"); return }
            .toInt()
            .also { profileRepository.setUserHeight(it) }
            .let { it * 6.25 }
        
        val enteredWeight = weight
            .ifEmpty { cView.showToast("Не выбран вес!"); return }
            .toInt()
            .also { profileRepository.setUserWeight(it) }
            .let { it * 10 }
        
        val enteredAge = age
            .ifEmpty { cView.showToast("Не выбран возраст!"); return }
            .toInt()
            .also { profileRepository.setUserAge(it) }
            .let { it * 5 }
        
        val enteredActive = when (active) {
            0L -> 1.0
            1L -> 1.4
            else -> 1.65
        }
        
        enteredWeight
            .plus(enteredHeight)
            .minus(enteredAge)
            .plus(dci)
            .times(enteredActive)
            .let { if (it > 0) it else 0 }
            .also { profileRepository.setUserCalories(it.toInt()) }
            .apply { cView.setResultCalculate(toInt()) }
    }
}