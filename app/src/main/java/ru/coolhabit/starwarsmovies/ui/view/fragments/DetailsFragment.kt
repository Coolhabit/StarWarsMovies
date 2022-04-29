package ru.coolhabit.starwarsmovies.ui.view.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import ru.coolhabit.starwarsmovies.data.entity.Film
import ru.coolhabit.starwarsmovies.databinding.FragmentDetailsBinding
import ru.coolhabit.starwarsmovies.ui.viewmodel.DetailsFragmentViewModel

private const val GENRE = "Genre"
private const val DELIMITER = "|"
private const val DURATION = "1 hr 30 m"
private const val RATIO = "Ratio"
private const val SYNOPSIS = "Synopsis"
private const val CAST_CREW = "Cast and Crew"
private const val FILM = "film"
private const val PIC_LINK = "w780"

class DetailsFragment : Fragment() {
    private lateinit var film: Film
    private lateinit var binding: FragmentDetailsBinding
    private val viewModel by lazy {
        ViewModelProvider.NewInstanceFactory().create(DetailsFragmentViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFilmsDetails()
    }

    private fun setFilmsDetails() {
        //Получаем наш фильм из переданного бандла
        film = arguments?.get(FILM) as Film

        //Устанавливаем заголовок
        binding.detailsTitle.text = film.title
        //Устанавливаем картинку
        Glide.with(this)
            .load(ru.coolhabit.remote_module.entity.ApiConstants.IMAGES_URL + PIC_LINK + film.poster)
            .centerCrop()
            .into(binding.detailsPoster)
        //Устанавливаем описание
        binding.detailsGenre.text = GENRE
        binding.detailsDelimiter1.text = DELIMITER
        binding.detailsDuration.text = DURATION
        binding.detailsRatioAdult.text = RATIO
        binding.detailsSynopsis.text = SYNOPSIS
        binding.detailsDescription.text = film.description
        binding.detailsCastCrew.text = CAST_CREW
    }
}

