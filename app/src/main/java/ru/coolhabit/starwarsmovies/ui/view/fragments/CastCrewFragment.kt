package ru.coolhabit.starwarsmovies.ui.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import ru.coolhabit.starwarsmovies.R
import ru.coolhabit.starwarsmovies.data.entity.Cast
import ru.coolhabit.starwarsmovies.data.entity.Film
import ru.coolhabit.starwarsmovies.databinding.FragmentCastCrewBinding
import ru.coolhabit.starwarsmovies.databinding.FragmentDetailsBinding
import ru.coolhabit.starwarsmovies.ui.view.rv_adapters.CastListRecyclerAdapter
import ru.coolhabit.starwarsmovies.ui.viewmodel.CastCrewFragmentViewModel
import ru.coolhabit.starwarsmovies.ui.viewmodel.DetailsFragmentViewModel

private const val FILM = "film"

class CastCrewFragment : Fragment() {
    private val viewModel by lazy {
        ViewModelProvider.NewInstanceFactory().create(CastCrewFragmentViewModel::class.java)
    }

    private lateinit var film: Film
    private lateinit var binding: FragmentCastCrewBinding
    private lateinit var castAdapter: CastListRecyclerAdapter
    private var castDataBase = listOf<Cast>()

            //Используем backing field
        set(value) {
            //Если придет такое же значение то мы выходим из метода
            if (field == value) return
            //Если пришло другое значение, то кладем его в переменную
            field = value
            //Обновляем RV адаптер
            castAdapter.addItems(field)
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCastCrewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        film = arguments?.get(FILM) as Film
        viewModel.getCastCrew(film.id)
        //находим наш RV
        initRecycler()
        //Кладем нашу БД в RV
        viewModel.castListData.observe(viewLifecycleOwner) {
            castDataBase = it
            castAdapter.addItems(it)
        }
    }

    private fun initRecycler() {
        //находим наш RV
        binding.castRecycler.apply {
            castAdapter =
                CastListRecyclerAdapter(object : CastListRecyclerAdapter.OnItemClickListener {
                    override fun click(cast: Cast) {
                        Toast.makeText(requireContext(), "Я - актер!", Toast.LENGTH_SHORT).show()
                    }
                })
            //Присваиваем адаптер
            adapter = castAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

}