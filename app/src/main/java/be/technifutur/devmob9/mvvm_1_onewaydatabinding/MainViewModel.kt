package be.technifutur.devmob9.mvvm_1_onewaydatabinding

import android.app.Application
import android.graphics.drawable.Drawable
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.AndroidViewModel

class MainViewModel(
    private val app: Application,
    var pokemon: Pokemon,
    searchName:String? = null) : AndroidViewModel(app), Observable {

    private var callbacks: PropertyChangeRegistry = PropertyChangeRegistry()

    var searchName: String? = null
        set(value) {
            field = value
            validateSearchName()
        }

    @get:Bindable
    var searchNameError: String? = null

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        callbacks.remove(callback)
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        callbacks.add(callback)
    }

    fun getName(): String {
        return pokemon.name
    }

    fun getDescription(): String {
        return pokemon.description
    }

    fun getImageResource(): Drawable? {
        return pokemon.imageResource
    }

    fun validateSearchName() {
        searchNameError = null
        if (searchName?.isEmpty() != false) {
            searchNameError = "Veuillez entrer un nom de Pokémon"
        } else if (searchName?.matches(Regex("[a-zA-ZÀ-ÿ]+")) == false) {
            searchNameError = "Veuillez n'entrer que des lettres"
        }
        println(searchNameError)
        callbacks.notifyChange(this, BR._all)
    }

}

