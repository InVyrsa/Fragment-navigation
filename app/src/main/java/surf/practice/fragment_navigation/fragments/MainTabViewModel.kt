package surf.practice.fragment_navigation.fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import surf.practice.fragment_navigation.R

class MainTabViewModel : ViewModel() {

    val selectedTab = MutableLiveData<Int>().apply { value = R.id.tab_1 }
}