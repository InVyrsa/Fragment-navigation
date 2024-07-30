package surf.practice.fragment_navigation.tabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import surf.practice.fragment_navigation.databinding.SecondTabFragmentBinding

class SecondTabFragment : Fragment() {

    private lateinit var binding: SecondTabFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SecondTabFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
    }

    private fun initListeners() = with(binding) {
        openDetailsBtn.setOnClickListener { /* TODO открытие детального фрагмента */ }
        openInnerBtn.setOnClickListener { /* TODO открытие внутреннего фрагмента */ }
    }
}