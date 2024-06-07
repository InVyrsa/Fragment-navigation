package surf.practice.fragment_navigation.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class TabFragmentNavigator(
    private val fragmentManager: FragmentManager,
    private val fragmentContainerId: Int
) {
    private var currentTabTag = ""
    private var tabs = mutableListOf<String>()

    private val isFirstTabAdding
        get() = currentTabTag == ""

    fun switchTab(fragment: Fragment, tabTag: String) {
        if (currentTabTag == tabTag) return
        if (!tabs.contains(tabTag)) {
            addNewTab(fragment, tabTag)
            return
        }

        fragmentManager.executePendingTransactions()
        fragmentManager.saveBackStack(currentTabTag)
        currentTabTag = tabTag
        fragmentManager.restoreBackStack(tabTag)
    }

    fun replace(fragment: Fragment) {
        fragmentManager.executePendingTransactions()
        fragmentManager.beginTransaction()
            .replace(fragmentContainerId, fragment)
            .setReorderingAllowed(true)
            .addToBackStack(currentTabTag)
            .commit()
    }

    fun popBackstack() {
        fragmentManager.popBackStack()
    }

    private fun addNewTab(fragment: Fragment, tabTag: String) {
        fragmentManager.executePendingTransactions()
        if (!isFirstTabAdding) {
            fragmentManager.saveBackStack(currentTabTag)
        }
        currentTabTag = tabTag
        tabs.add(tabTag)
        fragmentManager.beginTransaction()
            .replace(fragmentContainerId, fragment)
            .setReorderingAllowed(true)
            .addToBackStack(tabTag)
            .commit()
    }
}