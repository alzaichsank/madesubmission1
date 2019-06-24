package alzaichsank.com.movielist.datasource

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by alzaichsank on 2019-06-24.
 */

class MovieData(
    var id: Int = 0,
    var title: String? = null,
    var description: String? = null,
    var releaseDate: String? = null,
    var rating: String? = null,
    var imagePhoto: Int? = 0) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(title)
        parcel.writeString(description)
        parcel.writeString(releaseDate)
        parcel.writeString(rating)
        parcel.writeValue(imagePhoto)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MovieData> {
        override fun createFromParcel(parcel: Parcel): MovieData {
            return MovieData(parcel)
        }

        override fun newArray(size: Int): Array<MovieData?> {
            return arrayOfNulls(size)
        }
    }
}
