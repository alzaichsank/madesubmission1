package alzaichsank.com.movielist.view.main.home.detail

import alzaichsank.com.movielist.R
import alzaichsank.com.movielist.datasource.MovieData
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_DATA = "EXTRA_DATA"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        loadData()
    }

    private fun loadData() {
        val movieData: MovieData = intent.getParcelableExtra(EXTRA_DATA)
        movieData.imagePhoto?.let { image_view_banner.setImageResource(it) }
        movieData.title?.let { text_view_title.text = it }
        movieData.description?.let { text_view_description.text = it }
        movieData.rating?.let { text_view_rating.text = "$it${getString(R.string.max_rating)}" }
        movieData.releaseDate?.let { text_view_year_release.text = it }
    }
}
