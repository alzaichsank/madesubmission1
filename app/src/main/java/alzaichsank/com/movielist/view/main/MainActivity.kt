package alzaichsank.com.movielist.view.main

import alzaichsank.com.movielist.R
import alzaichsank.com.movielist.extensions.disableShiftMode
import alzaichsank.com.movielist.view.main.account.FragmentAccount
import alzaichsank.com.movielist.view.main.home.FragmentHome
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        navigation.setOnNavigationItemSelectedListener(bottomNavigationListener)
        navigation.disableShiftMode()
        setToDashboard()
    }

    private val bottomNavigationListener by lazy {
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    setToDashboard()
                    true
                }
                R.id.navigation_tv_show -> {
                    setAccount()
                    true
                }
                R.id.navigation_account -> {
                    setAccount()
                    true
                }
                else -> {
                    setToDashboard()
                    true
                }
            }
        }
    }

    private fun setToDashboard() {
        loadFragment(FragmentHome(), FragmentHome.TAG)
    }

    private fun setAccount() {
        loadFragment(FragmentAccount(), FragmentAccount.TAG)
    }

    private fun loadFragment(fragment: Fragment, tag: String?) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_fragment, fragment, tag)
        transaction.addToBackStack(null)
        transaction.commit()
    }


}
