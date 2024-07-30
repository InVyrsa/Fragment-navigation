package surf.practice.fragment_navigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import surf.practice.fragment_navigation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        /* TODO открытие фрагмента с табами */
    }
}