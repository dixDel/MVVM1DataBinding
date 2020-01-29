package be.technifutur.devmob9.mvvm_1_onewaydatabinding

import android.app.Application
import androidx.databinding.Observable
import androidx.lifecycle.AndroidViewModel

class MainViewModel : AndroidViewModel(Application()), Observable {

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

