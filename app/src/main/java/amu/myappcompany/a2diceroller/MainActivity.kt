package amu.myappcompany.a2diceroller

import amu.myappcompany.a2diceroller.databinding.ActivityMainBinding
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**This activity allows the user to roll 2 dice and view the results
 * on the screen
 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Find the Roll button and make it to listen to clicks
        binding.button.setOnClickListener { rollDice() }


    }

    var counter: Int = 10



    /**
     * Roll the 2 dice and update the screen with the results
     */
    private fun rollDice() {
        //create a new Dice object with 6 sides
        val dice = Dice(6)

        //rolling the 2 dice
        val firstDiceRoll = dice.roll()
        val secondDiceRoll = dice.roll()
        val total1: Int = firstDiceRoll + secondDiceRoll
        val total2: Int = total1 + firstDiceRoll + secondDiceRoll
        val total3: Int = total2 + firstDiceRoll + secondDiceRoll
        val total4: Int = total3 + firstDiceRoll + secondDiceRoll
        val total5: Int = total4 + firstDiceRoll + secondDiceRoll
        val total6: Int = total5 + firstDiceRoll + secondDiceRoll
        val total7: Int = total6 + firstDiceRoll + secondDiceRoll
        val total8: Int = total7 + firstDiceRoll + secondDiceRoll
        val total9: Int = total8 + firstDiceRoll + secondDiceRoll
        val total10: Int = total9 + firstDiceRoll + secondDiceRoll

        counter--


        when (counter) {

            9 -> binding.scoreBoard.text = total1.toString()
            8 -> binding.scoreBoard.text = total2.toString()
            7 -> binding.scoreBoard.text = total3.toString()
            6 -> binding.scoreBoard.text = total4.toString()
            5 -> binding.scoreBoard.text = total5.toString()
            4 -> binding.scoreBoard.text = total6.toString()
            3 -> binding.scoreBoard.text = total7.toString()
            2 -> binding.scoreBoard.text = total8.toString()
            1 -> binding.scoreBoard.text = total9.toString()
            0 -> binding.scoreBoard.text = total10.toString()

        }



        if (counter == -1) counter = 10
        val timerForGame: TextView = findViewById(R.id.timer_board)
        timerForGame.text = counter.toString()





        //update the screen with the dice roll result of individual dice
        val diceImage1: ImageView = findViewById(R.id.imageView)
        val drawableResource = when (firstDiceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage1.setImageResource(drawableResource)
        diceImage1.contentDescription = firstDiceRoll.toString()

        val diceImage2: ImageView = findViewById(R.id.imageView3)
        val drawableResource2 = when (secondDiceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage2.setImageResource(drawableResource2)
        diceImage2.contentDescription = secondDiceRoll.toString()

    }

}

class Dice(private val numSides: Int) {
    fun roll(): Int {

        return (1..numSides).random()
    }

}
