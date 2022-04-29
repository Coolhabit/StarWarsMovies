package ru.coolhabit.starwarsmovies.ui.view.rv_viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.coolhabit.starwarsmovies.data.entity.Film
import ru.coolhabit.starwarsmovies.databinding.FilmItemBinding

private const val GENRE = "Genre"
private const val RATIO = "Ratio"
private const val DURATION = "1 hr 30 m"
private const val DELIMITER = "|"

///В конструктор класс передается layout, который мы создали(film_item.xml)
class FilmViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val filmItemBinding = FilmItemBinding.bind(itemView)
    //Привязываем view из layout к переменным
    private val title = filmItemBinding.title
    private val poster = filmItemBinding.poster
    private val genre = filmItemBinding.genre
    private val duration = filmItemBinding.duration
    private val ratio = filmItemBinding.ratioAdult
    private val delimiter1 = filmItemBinding.delimiter1
    private val delimiter2 = filmItemBinding.delimiter2

    //В этом методе кладем данные из film в наши view
    fun bind(film: Film) {
        //Устанавливаем заголовок
        title.text = film.title
        genre.text = GENRE
        duration.text = DURATION
        ratio.text = RATIO
        delimiter1.text = DELIMITER
        delimiter2.text = DELIMITER
        //Устанавливаем постер
        //Указываем контейнер, в которм будет "жить" наша картинка
        Glide.with(itemView)
            //Загружаем сам ресурс
            .load(ru.coolhabit.remote_module.entity.ApiConstants.IMAGES_URL + "w342" + film.poster)
            //Центруем изображение
            .centerCrop()
            //Указываем ImageView, куда будем загружать изображение
            .into(poster)
    }
}