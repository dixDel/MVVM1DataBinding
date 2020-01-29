package be.technifutur.devmob9.mvvm_1_onewaydatabinding

import android.graphics.drawable.Drawable
import androidx.databinding.BaseObservable

class Pokemon(
    name: String = "",
    val description: String,
    val imageResource: Drawable,

    var nameError: String? = null
): BaseObservable() {

    var name: String = name
        set(value) {
            field = value
            notifyChange()
        }

    var searchName: String = name
        set(value) {
            field = value
            validateSearchName()
    }

    private fun validateSearchName() {
        if (name.isEmpty()) {
            nameError = "Veuillez entrer un nom de Pokémon"
        } else if (!name.matches(Regex("[a-zA-ZÀ-ÿ]+"))) {
            nameError = "Veuillez n'entrer que des lettres"
        }
        notifyChange()
    }
}