package com.magotecnologia.hw1_guessinggame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.magotecnologia.hw1_guessinggame.databinding.ActivityNumberGuessBinding
import kotlinx.android.synthetic.main.activity_number_guess.*

class NumberGuessActivity : AppCompatActivity() {

    lateinit var binding:ActivityNumberGuessBinding
    var randomNumber=0
    var tries=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNumberGuessBinding.inflate(layoutInflater)
        setContentView(binding.root)
        generateRandom()
        binding.guessButton.setOnClickListener {
            compareGuess(binding.guess.text.toString().toInt())
        }
        binding.retry.setOnClickListener {
            tries=0
            generateRandom()
            guess_button.isEnabled=true
        }
    }

    private fun compareGuess(guess: Int) {
        tries++
        when  {
            guess==randomNumber -> {
                binding.guessButton.isEnabled=false
                binding.hint.text="${resources.getString(R.string.win)} $tries ${resources.getString(R.string.tries)}"

            }
            guess>randomNumber-> {
                    binding.hint.text=resources.getString(R.string.lower)}
            else->{
                    binding.hint.text=resources.getString(R.string.higher)
                }
            }

    }

    private fun generateRandom(){
        this.randomNumber=(1.. 1000).shuffled().first()
    }

}
