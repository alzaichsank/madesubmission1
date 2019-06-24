package alzaichsank.com.movielist.view.main.home

import alzaichsank.com.movielist.R
import alzaichsank.com.movielist.datasource.MovieData
import alzaichsank.com.movielist.util.Logger
import alzaichsank.com.movielist.view.main.home.adapter.MovieAdapter
import android.annotation.SuppressLint
import android.content.res.TypedArray
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Created by alzaichsank on 2019-06-24.
 */

class FragmentHome : Fragment() {
    private var dataTitle: Array<String>? = null
    private var dataDescription: Array<String>? = null
    private var dataRelease: Array<String>? = null
    private var dataRating: Array<String>? = null
    private var dataPhoto: TypedArray? = null
    private var adapterMovie: MovieAdapter? = null
    private lateinit var movieData: ArrayList<MovieData>

    companion object {
        const val TAG = "HOME_FRAGMENT"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initLayout()
    }

    @SuppressLint("CheckResult")
    private fun initLayout() {
        initLoadData()
        initListView()
    }

    private fun initLoadData() {
        dataTitle = resources.getStringArray(R.array.title)
        dataDescription = resources.getStringArray(R.array.description)
        dataRelease = resources.getStringArray(R.array.release_date)
        dataRating = resources.getStringArray(R.array.rating)
        dataPhoto = resources.obtainTypedArray(R.array.image)
    }

    private fun initListView() {
        movieData = ArrayList()
        for (i in 0 until (dataTitle?.size ?: 0)) {
            val data = MovieData()
            data.id = i + 1
            data.title = dataTitle?.get(i)
            data.description = dataDescription?.get(i)
            data.releaseDate = dataRelease?.get(i)
            data.rating = dataRating?.get(i)
            data.imagePhoto = dataPhoto?.getResourceId(i, i)
            movieData.add(data)
            Logger.debug("cek data >> ${movieData[i].title}")
        }
        adapterMovie = MovieAdapter(this.context!!, movieData)
        list_view_film.adapter = adapterMovie
        adapterMovie!!.notifyDataSetChanged()
    }
}