package surf.practice.fragment_navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import surf.practice.fragment_navigation.databinding.ActivityMainBinding
import surf.practice.fragment_navigation.fragments.MainTabFragment
import surf.practice.fragment_navigation.navigation.RootFragmentNavigator
import surf.practice.fragment_navigation.navigation.TabFragmentNavigator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    var rootFragmentNavigator = RootFragmentNavigator(
        fragmentManager = supportFragmentManager,
        fragmentContainerId = R.id.root_fragment_container,
        rootTag = "MainActivityBackStack"
    )
    var tabFragmentNavigator: TabFragmentNavigator? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        rootFragmentNavigator.replace(
            fragment = MainTabFragment(),
            shouldAddToBackStack = false
        )
    }
}