package ru.coolhabit.starwarsmovies.ui

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import ru.coolhabit.starwarsmovies.R
import ru.coolhabit.starwarsmovies.data.entity.Film
import ru.coolhabit.starwarsmovies.databinding.ActivityMainBinding
import ru.coolhabit.starwarsmovies.ui.view.fragments.DetailsFragment
import ru.coolhabit.starwarsmovies.ui.view.fragments.HomeFragment

class MainActivity : AppCompatActivity() {

    companion object {
        const val FILM = "film"
    }

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Запускаем фрагмент при старте
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_placeholder, HomeFragment())
            .addToBackStack(null)
            .commit()
    }

    fun launchDetailsFragment(film: Film) {
        //Создаем "посылку"
        val bundle = Bundle()
        //Кладем наш фильм в "посылку"
        bundle.putParcelable(FILM, film)
        //Кладем фрагмент с деталями в переменную
        val fragment = DetailsFragment()
        //Прикрепляем нашу "посылку" к фрагменту
        fragment.arguments = bundle

        //Запускаем фрагмент
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_placeholder, fragment)
            .addToBackStack(null)
            .commit()
    }
}