package surf.practice.fragment_navigation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import surf.practice.fragment_navigation.R
import surf.practice.fragment_navigation.databinding.MainTabFragmentBinding

class MainTabFragment : Fragment() {

    private lateinit var binding: MainTabFragmentBinding

    private val viewModel: MainTabViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainTabFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
        initObservers()
    }

    private fun initListeners() = with(binding) {
        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            viewModel.selectedTab.value = menuItem.itemId
            true
        }
    }

    private fun initObservers() {
        viewModel.selectedTab.observe(viewLifecycleOwner) {
            when (it) {
                R.id.tab_1 -> Unit
                R.id.tab_2 -> Unit
                R.id.tab_3 -> Unit
                R.id.tab_4 -> Unit
            }
        }
    }
}