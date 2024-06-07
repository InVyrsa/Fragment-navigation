package surf.practice.fragment_navigation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import surf.practice.fragment_navigation.databinding.InnerFragmentBinding

class InnerFragment : Fragment() {

    private lateinit var binding: InnerFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = InnerFragmentBinding.inflate(layoutInflater)
        return binding.root
    }
}