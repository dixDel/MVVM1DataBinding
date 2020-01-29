package be.technifutur.devmob9.mvvm_1_onewaydatabinding

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivityViewModelFactory(private var application: Application, private var pokemon: Pokemon) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(application, pokemon) as T
    }
}