package be.technifutur.devmob9.mvvm_1_onewaydatabinding

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivityViewModelFactory(private var application: Application, private val startItem: Int = 0) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(application, startItem) as T
    }
}