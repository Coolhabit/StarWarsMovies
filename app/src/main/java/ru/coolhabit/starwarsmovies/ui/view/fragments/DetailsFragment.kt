package ru.coolhabit.starwarsmovies.ui.view.fragments


import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import ru.coolhabit.starwarsmovies.R
import ru.coolhabit.starwarsmovies.data.entity.Cast
import ru.coolhabit.starwarsmovies.data.entity.Film
import ru.coolhabit.starwarsmovies.data.entity.Movie
import ru.coolhabit.starwarsmovies.databinding.FragmentDetailsBinding
import ru.coolhabit.starwarsmovies.ui.MainActivity
import ru.coolhabit.starwarsmovies.ui.view.rv_adapters.CastListRecyclerAdapter
import ru.coolhabit.starwarsmovies.ui.view.rv_adapters.FilmListRecyclerAdapter
import ru.coolhabit.starwarsmovies.ui.viewmodel.DetailsFragmentViewModel
import java.util.Observer

private const val GENRE = "Genre"
private const val SYNOPSIS = "Synopsis"
private const val CAST_CREW = "Cast and Crew"
private const val FILM = "film"
private const val PIC_LINK = "w780"

class DetailsFragment : Fragment() {
    private val viewModel by lazy {
        ViewModelProvider.NewInstanceFactory().create(DetailsFragmentViewModel::class.java)
    }

    private lateinit var castAdapter: CastListRecyclerAdapter
    private lateinit var film: Film
    private lateinit var binding: FragmentDetailsBinding
    private var castDataBase = listOf<Cast>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
        setHasOptionsMenu(true)
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
        film = arguments?.get(FILM) as Film
        viewModel.getData(film.id)
        viewModel.getCastCrew(film.id)
        setFilmsDetails()
        //находим наш RV
        initRecycler()
        //Кладем нашу БД в RV
        viewModel.castListData.observe(viewLifecycleOwner) {
            castDataBase = it
            castAdapter.addItems(it)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.fragment_details_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.film_share -> {
                Toast.makeText(requireContext(), "И он не делится властью!", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setFilmsDetails() {
        //Получаем наш фильм из переданного бандла
        //Устанавливаем картинку

        //Устанавливаем описание
        binding.detailsGenre.text = GENRE
        binding.detailsSynopsis.text = SYNOPSIS
        binding.detailsCastCrew.text = CAST_CREW

        viewModel.liveData.observe(viewLifecycleOwner) {
            binding.detailsTitle.text = it.title
            binding.detailsDescription.text = it.description

            val hr = it.runtime / 60
            val min = it.runtime % 60
            binding.detailsDuration.text = "$hr hr $min min"

            Glide.with(this)
                .load(ru.coolhabit.remote_module.entity.ApiConstants.IMAGES_URL + PIC_LINK + it.poster)
                .centerCrop()
                .into(binding.detailsPoster)
        }
    }

    private fun initRecycler() {
        //находим наш RV
        binding.castRecycler.apply {
            castAdapter =
                CastListRecyclerAdapter(object : CastListRecyclerAdapter.OnItemClickListener {
                    override fun click(cast: Cast) {
                        (activity as MainActivity).launchCastCrewFragment(film)
                    }
                })
            //Присваиваем адаптер
            adapter = castAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }
}

