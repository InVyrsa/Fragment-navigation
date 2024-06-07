package surf.practice.fragment_navigation.tabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import surf.practice.fragment_navigation.MainActivity
import surf.practice.fragment_navigation.databinding.ThirdTabFragmentBinding
import surf.practice.fragment_navigation.fragments.DetailsFragment

class ThirdTabFragment : Fragment() {

    private lateinit var binding: ThirdTabFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ThirdTabFragmentBinding.inflate(layoutInflater)
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
    }
}