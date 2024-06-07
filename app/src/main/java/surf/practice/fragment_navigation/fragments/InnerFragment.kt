package surf.practice.fragment_navigation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import surf.practice.fragment_navigation.MainActivity
import surf.practice.fragment_navigation.databinding.InnerFragmentBinding

const val INNER_FRAGMENT_TAB_ID = "TabId"

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initListeners()
    }

    private fun initViews() {
        val tabId = arguments?.getInt(INNER_FRAGMENT_TAB_ID)
        binding.innerFragmentTv.text = "Внутренний фрагмент таба $tabId"
    }

    private fun initListeners() = with(binding) {
        backBtn.setOnClickListener {
            (activity as MainActivity).tabFragmentNavigator?.popBackstack()
        }
    }
}