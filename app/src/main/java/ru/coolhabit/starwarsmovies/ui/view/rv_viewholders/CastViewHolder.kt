package ru.coolhabit.starwarsmovies.ui.view.rv_viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.coolhabit.starwarsmovies.data.entity.Cast
import ru.coolhabit.starwarsmovies.databinding.CastItemBinding

class CastViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val castItemBinding = CastItemBinding.bind(itemView)
    //Привязываем view из layout к переменным
    private val poster = castItemBinding.castPoster
    private val name = castItemBinding.castName
    private val character = castItemBinding.castCharacter


    //В этом методе кладем данные из cast в наши view
    fun bind(cast: Cast) {
        //Устанавливаем заголовок
        name.text = cast.name
        character.text = cast.character

        //Устанавливаем постер
        //Указываем контейнер, в которм будет "жить" наша картинка
        Glide.with(itemView)
            //Загружаем сам ресурс
            .load(ru.coolhabit.remote_module.entity.ApiConstants.IMAGES_URL + "w342" + cast.portrait)
            //Центруем изображение
            .centerCrop()
            //Указываем ImageView, куда будем загружать изображение
            .into(poster)
    }
}