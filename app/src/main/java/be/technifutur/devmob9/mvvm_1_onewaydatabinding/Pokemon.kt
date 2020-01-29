package be.technifutur.devmob9.mvvm_1_onewaydatabinding

import android.graphics.drawable.Drawable
import androidx.databinding.BaseObservable

class Pokemon(
    name: String = "",
    val description: String,
    val imageResource: Drawable,

    var test: String? = null
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

    private fun validateSearchName() {
        test = null
        if (searchName?.isEmpty() == true) {
            test = "Veuillez entrer un nom de Pokémon"
        } else if (searchName?.matches(Regex("[a-zA-ZÀ-ÿ]+")) == false) {
            test = "Veuillez n'entrer que des lettres"
        }
        notifyChange()
    }
}