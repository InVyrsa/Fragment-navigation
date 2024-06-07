package surf.practice.fragment_navigation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import surf.practice.fragment_navigation.MainActivity
import surf.practice.fragment_navigation.R
import surf.practice.fragment_navigation.navigation.TabFragmentNavigator
import surf.practice.fragment_navigation.databinding.MainTabFragmentBinding
import surf.practice.fragment_navigation.tabs.FirstTabFragment
import surf.practice.fragment_navigation.tabs.FourthTabFragment
import surf.practice.fragment_navigation.tabs.SecondTabFragment
import surf.practice.fragment_navigation.tabs.ThirdTabFragment

class MainTabFragment : Fragment() {

    private lateinit var binding: MainTabFragmentBinding

    private val viewModel: MainTabViewModel by viewModels()
    private lateinit var tabFragmentNavigator: TabFragmentNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tabFragmentNavigator = TabFragmentNavigator(
            childFragmentManager,
            R.id.tab_fragment_container
        )
        (activity as MainActivity).tabFragmentNavigator = tabFragmentNavigator
    }

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

    override fun onDetach() {
        (activity as MainActivity).tabFragmentNavigator = null
        super.onDetach()
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
                R.id.tab_1 -> tabFragmentNavigator.switchTab(
                    fragment = FirstTabFragment(),
                    tabTag = "tab_1"
                )

                R.id.tab_2 -> tabFragmentNavigator.switchTab(
                    fragment = SecondTabFragment(),
                    tabTag = "tab_2"
                )

                R.id.tab_3 -> tabFragmentNavigator.switchTab(
                    fragment = ThirdTabFragment(),
                    tabTag = "tab_3"
                )

                R.id.tab_4 -> tabFragmentNavigator.switchTab(
                    fragment = FourthTabFragment(),
                    tabTag = "tab_4"
                )
            }
        }
    }
}