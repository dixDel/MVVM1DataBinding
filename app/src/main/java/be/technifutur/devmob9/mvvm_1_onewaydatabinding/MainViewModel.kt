package be.technifutur.devmob9.mvvm_1_onewaydatabinding

import android.app.Application
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.AndroidViewModel

class MainViewModel(val app: Application, val pokemon: Pokemon) : AndroidViewModel(app), Observable {

    private var callbacks: PropertyChangeRegistry = PropertyChangeRegistry()

    var searchNameError: String? = null

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        callbacks.remove(callback)
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        callbacks.add(callback)
    }

    fun validateSearchName() {
        searchNameError = null
        if (pokemon.searchName?.isEmpty() != false) {
            searchNameError = "Veuillez entrer un nom de Pokémon"
        } else if (pokemon.searchName?.matches(Regex("[a-zA-ZÀ-ÿ]+")) == false) {
            searchNameError = "Veuillez n'entrer que des lettres"
        }
        println(searchNameError)
        pokemon.notifyChange()
    }

}

