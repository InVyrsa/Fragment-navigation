package surf.practice.fragment_navigation.tabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import surf.practice.fragment_navigation.databinding.FourthTabFragmentBinding

class FourthTabFragment : Fragment() {

    private lateinit var binding: FourthTabFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FourthTabFragmentBinding.inflate(layoutInflater)
        return binding.root
    }
}