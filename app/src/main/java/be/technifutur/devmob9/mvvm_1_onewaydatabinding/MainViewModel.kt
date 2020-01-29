package be.technifutur.devmob9.mvvm_1_onewaydatabinding

import android.app.Application
import androidx.databinding.Observable
import androidx.lifecycle.AndroidViewModel

class MainViewModel(val app: Application) : AndroidViewModel(app), Observable {

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

}

