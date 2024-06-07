package surf.practice.fragment_navigation.tabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import surf.practice.fragment_navigation.MainActivity
import surf.practice.fragment_navigation.databinding.FirstTabFragmentBinding
import surf.practice.fragment_navigation.fragments.DetailsFragment
import surf.practice.fragment_navigation.fragments.INNER_FRAGMENT_TAB_ID
import surf.practice.fragment_navigation.fragments.InnerFragment

class FirstTabFragment : Fragment() {

    private lateinit var binding: FirstTabFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FirstTabFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
    }

    private fun initListeners() = with(binding) {
        openDetailsBtn.setOnClickListener {
            (activity as MainActivity).rootFragmentNavigator.replace(DetailsFragment())
        }
        openInnerBtn.setOnClickListener {
            val innerFragment = InnerFragment().apply {
                arguments = bundleOf(INNER_FRAGMENT_TAB_ID to 1)
            }
            (activity as MainActivity).tabFragmentNavigator?.replace(innerFragment)
        }
    }
}