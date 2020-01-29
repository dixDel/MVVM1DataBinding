package be.technifutur.devmob9.mvvm_1_onewaydatabinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import be.technifutur.devmob9.mvvm_1_onewaydatabinding.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.java.simpleName
    private val pokemons = arrayListOf<Pokemon>()

    private var mainBinding: ActivityMainBinding? = null
    private var index: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.pokemons.add(Pokemon(
            "Charmander",
            "Charmander is a bipedal, reptilian Pokémon with a primarily orange body and blue eyes. Its underside from the chest down and the soles of its feet are cream-colored. It has two small fangs visible in its upper jaw and two smaller fangs in its lower jaw. A fire burns at the tip of this Pokémon's slender tail and has blazed there since Charmander's birth. The flame can be used as an indication of Charmander's health and mood, burning brightly when the Pokémon is strong, weakly when it is exhausted, wavering when it is happy, and blazing when it is enraged. It is said that Charmander dies if its flame goes out. However, if the Pokémon is healthy, the flame will continue to burn even if it gets a bit wet and is said to steam in the rain.\nCharmander can be found in hot, mountainous areas. However, it is found far more often in the ownership of Trainers. As shown in Pokémon Snap, Charmander exhibits pack behavior, calling others of its species if it finds food.",
            resources.getDrawable(R.drawable.charmander, theme)
        ))
        this.pokemons.add(Pokemon(
            "Rhydon",
            "Rhydon is a large, gray, bipedal Pokémon with features similar to both dinosaurs and rhinoceroses. It has narrow, red eyes and two fangs in its upper jaw. On the tip of its snout is a cream-colored horn, which is smaller on a female than a male. There are several other spikes and projections on its head: on top is spike that curves forward, two triangular points resembling ears on the sides, a wide, wavy crest under each ear, and spiky ridges on each cheek. It has a cream-colored abdomen divided into strips by thin divots. A rocky plate on its chest slightly overlaps its abdomen. There is a row of spikes down its back, and has a long tail with thin, black stripes.\nRhydon is a physically powerful Pokémon. It is recorded as being able to topple buildings with a sweeping blow of its tail, and its horn is able to bore through solid rock and shatter diamonds. Its armor-like hide protects it from heat and physical blows. It is stated to be capable of passing unscathed through streams of magma and withstanding a direct blow from a cannonball without being harmed. However, because of this tough hide, it is insensitive. Despite its well-developed brain, it can be forgetful. Rhydon lives in rough terrain.",
            resources.getDrawable(R.drawable.rhydon, theme)
        ))
        this.pokemons.add(Pokemon(
            "Exeggutor",
            "Exeggutor is a tall, bipedal Pokémon that resembles a palm tree. Its body and legs are light brown with thin black rings and its legs are thick with two-toed feet. There light yellow paw pad on each foot's underside. It has thin, green leaves sprouting from the top of its body. Exeggutor has three to six round, light yellow heads that resemble coconuts, each with differing facial expressions.\nEach head thinks independently of the others, so it makes a lot of noise as each head speaks its mind. If all the heads want to go in a different direction, its body is unable to move. They are able to communicate telepathically as well and sometimes use it to come to a joint decision. It uses psychic powers to fight, and since all three heads are capable its power is tripled. If one of these heads grows too large, it falls off and groups back together to become an Exeggcute. In the anime, Exeggutor also has been seen in groups of its own kind, meaning that it is not a solitary Pokémon. Being the result of an evolution via evolutionary stone, Exeggutor is rarely found in the wild, though they can be found in forests and jungles.",
            resources.getDrawable(R.drawable.exeggutor, theme)
        ))
        this.pokemons.add(Pokemon(
            "Nidoqueen",
            "Nidoqueen is a large, bipedal blue Pokémon with distinct reptilian features. Its body is encased with extremely hard scales that serve as excellent protection from any attack and stand up when Nidoqueen is excited or provoked. It has a blunt snout, narrow brown eyes, and large ears with brown insides. There is a small horn on its forehead, a single spine on each ear, and a line of toxic spikes running down the length of its back. Each hand has three short claws and each foot was two claws. Its lower jaw, the front of its abdomen, and two plates on its chest are cream-colored. It has a thick, powerful tail.\nNidoqueen can be quite fierce and is very protective of its young. This Pokémon is at its strongest when it is defending its young, and it will try to seal the entrance to its burrow to protect them. When in contact with foes, it can poison them with the spikes from its back or cause small tremors by slamming the ground. It is also adept at sending foes flying with harsh tackles and it uses its hefty bulk to execute powerful moves. Being the result of an evolution via evolutionary stone, Nidoqueen is rarely found in the wild, though they can be found in savannas and plains.",
            resources.getDrawable(R.drawable.nidoqueen, theme)
        ))
        this.pokemons.add(Pokemon(
            "Arcanine",
            "Arcanine is a quadruped, canine Pokémon with an orange pelt marked by jagged black stripes. It has diamond-shaped ears with beige insides, black eyes, a round, black nose, and two pointed teeth protruding from its upper jaw. Its head, muzzle, and chest are covered in shaggy, beige fur, except for two oval sections around each eye and ear. Long tufts of fur grow behind its elbows and around its ankles. Its underside is black, and it has a billowing, beige tail that is bent in the middle. Each paw has three toes and a round, pink pad.\nArcanine is a fiercely brave and loyal Pokémon. It is capable of running 6,200 miles (10,000 kilometers) in 24 hours with a speed and grace reminiscent of flight. Additionally, the move Extreme Speed was its signature move in the past. Arcanine has long been admired for its beauty and speed, and anyone who hears its bark will grovel before it. The source of its power is a flame blazing wildly inside its body. Being the result of an evolution via evolutionary stone, Arcanine is rarely found in the wild, but when found, it is usually seen living in prairies, and Pokémon Snap has also shown it living in active volcanoes. In the anime, it was shown that it stashes food in its mane and carries it to its nest for its young.",
            resources.getDrawable(R.drawable.arcanine, theme)
        ))

        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainBinding?.pokemon = this.pokemons[index]

        searchEditText.setSingleLine()
        searchButton.setOnClickListener {
            val pokemon: Pokemon? = this.pokemons.firstOrNull {
                    it.name == searchEditText.text.toString()
                }
            if (pokemon != null) {
                Log.d(TAG, "Match found: ${pokemon.name}")
                index = this.pokemons.indexOf(pokemon)
                updateDisplay()
            } else {
                Toast.makeText(this, "Aucun Pokémon avec le nom ${searchEditText.text} n'a été trouvé !", Toast.LENGTH_SHORT).show()
            }
        }

        previousButton.isEnabled = false
        if (pokemons.size <= 1) {
            nextButton.isEnabled = false
        }
        previousButton.setOnClickListener {
            if (index > 0) {
                index--
                this.updateDisplay()
            }
        }
        nextButton.setOnClickListener {
            if (index < pokemons.size - 1) {
                index++
                this.updateDisplay()
            }
        }
    }

    private fun updateDisplay() {
        previousButton.isEnabled = index > 0
        nextButton.isEnabled = index < this.pokemons.size - 1
        mainBinding?.pokemon = pokemons[index]
    }
}
