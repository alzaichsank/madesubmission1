package alzaichsank.com.movielist.view.main.account

import alzaichsank.com.movielist.R
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 * Created by alzaichsank on 2019-06-24.
 */

class FragmentAccount : Fragment() {

    companion object {
        const val TAG = "ACCOUNT_FRAGMENT"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_account, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initLayout()
    }

    @SuppressLint("CheckResult")
    private fun initLayout() {
        /*TO DO*/
    }

}