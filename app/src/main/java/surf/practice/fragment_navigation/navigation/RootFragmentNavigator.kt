package surf.practice.fragment_navigation.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class RootFragmentNavigator(
    private val fragmentManager: FragmentManager,
    private val fragmentContainerId: Int,
    private val rootTag: String
) {

    fun replace(fragment: Fragment, shouldAddToBackStack: Boolean = true) {
        fragmentManager.executePendingTransactions()
        fragmentManager
            .beginTransaction()
            .replace(fragmentContainerId, fragment)
            .addToBackStackIf(
                condition = shouldAddToBackStack,
                tagName = rootTag
            )
            .commit()
    }

    private fun FragmentTransaction.addToBackStackIf(
        condition: Boolean,
        tagName: String
    ): FragmentTransaction {
        return if (condition) {
            addToBackStack(tagName)
        } else {
            this
        }
    }
}