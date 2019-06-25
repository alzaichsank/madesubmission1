package alzaichsank.com.movielist.view.main.home.adapter

import alzaichsank.com.movielist.datasource.MovieData
import alzaichsank.com.movielist.view.main.home.detail.DetailActivity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_movie_list.view.*

/**
 * Created by alzaichsank on 2019-06-24.
 */

class MovieAdapter(private val context: Context, private val movieModelArrayList: ArrayList<MovieData>) :
    RecyclerView.Adapter<MovieViewHolder>() {

    private var movieData: ArrayList<MovieData>? = movieModelArrayList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(alzaichsank.com.movielist.R.layout.item_movie_list, null)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int = movieModelArrayList.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindData(movieData!![position])
    }
}

class MovieViewHolder(view: View) :
    RecyclerView.ViewHolder(view) {

    fun bindData(data: MovieData) {
        itemView.text_view_title.text = data.title
        itemView.text_view_rating.text = data.rating
        itemView.text_view_kategori.text = data.releaseDate
        data.imagePhoto?.let { itemView.image_view_poster.setImageResource(it) }
        itemView.user_layout.setOnClickListener {
            val moveWithObjectIntent = Intent(itemView.context, DetailActivity::class.java)
            moveWithObjectIntent.putExtra(DetailActivity.EXTRA_DATA, data)
            itemView.context.startActivity(moveWithObjectIntent)
        }
    }
}
