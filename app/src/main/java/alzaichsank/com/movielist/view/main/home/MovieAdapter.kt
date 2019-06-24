package alzaichsank.com.movielist.view.main.home

import alzaichsank.com.movielist.R
import alzaichsank.com.movielist.datasource.MovieData
import alzaichsank.com.movielist.util.Logger
import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.item_movie_list.view.*


/**
 * Created by alzaichsank on 2019-06-24.
 */

class MovieAdapter(private val context: Context, private val movieModelArrayList: ArrayList<MovieData>) :
    BaseAdapter() {

    private var movieData: ArrayList<MovieData>? = movieModelArrayList

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.item_movie_list, null)
        val holder = MovieItemViewHolder()
        holder.bindData(movieData!![position], view)
        return view
    }

    override fun getItem(position: Int): Any {
        return movieData?.get(position) ?: movieModelArrayList
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        Logger.debug("cek data on adapter ${movieData!!.size}")
        return movieData?.size!!
    }

}

class MovieItemViewHolder {

    fun bindData(data: MovieData, viewItem: View) {
        viewItem.text_view_title.text = data.title
        viewItem.text_view_rating.text = data.rating
        viewItem.text_view_kategori.text = data.releaseDate
        data.imagePhoto?.let { viewItem.image_view_poster.setImageResource(it) }
    }

}