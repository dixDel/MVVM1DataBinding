package be.technifutur.devmob9.mvvm_1_onewaydatabinding

import android.graphics.drawable.Drawable
import androidx.databinding.BaseObservable

class Pokemon(
    name: String = "",
    val description: String,
    val imageResource: Drawable,

    var searchNameError: String? = null
): BaseObservable() {

    var name: String = name
        set(value) {
            field = value
            notifyChange()
        }

    var searchName: String? = null
        set(value) {
            field = value
            validateSearchName()
    }

    fun validateSearchName() {
        searchNameError = null
        if (searchName?.isEmpty() != false) {
            searchNameError = "Veuillez entrer un nom de Pokémon"
        } else if (searchName?.matches(Regex("[a-zA-ZÀ-ÿ]+")) == false) {
            searchNameError = "Veuillez n'entrer que des lettres"
        }
        println(searchNameError)
        notifyChange()
    }
}