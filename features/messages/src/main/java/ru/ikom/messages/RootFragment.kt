package ru.ikom.messages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.commit
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.ikom.messages.databinding.RootFragmentBinding

class RootFragment : Fragment() {

    private var _binding: RootFragmentBinding? = null
    private val binding: RootFragmentBinding get() = _binding!!

    private val deps: MessagesDepsViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        childFragmentManager.fragmentFactory = fragmentFactoryImpl
        super.onCreate(savedInstanceState)

        // test

        if (savedInstanceState == null) {
            childFragmentManager.commit {
                replace(R.id.content, fragmentFactoryImpl.messagesFragment())
                addToBackStack(null)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = RootFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun onOpenDetails(name: String) {
        fragmentFactoryImpl.detailsFragment().setArguments(name).show(childFragmentManager, null)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private val fragmentFactoryImpl = object : FragmentFactory() {
        override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
            return when (loadFragmentClass(classLoader, className)) {
                MessagesFragment::class.java -> messagesFragment()
                DetailsFragment::class.java -> detailsFragment()
                else -> super.instantiate(classLoader, className)
            }
        }

        fun messagesFragment(): MessagesFragment =
            MessagesFragment(
                repository = deps.repository,
                onOpenDetails = ::onOpenDetails
            )

        fun detailsFragment(): DetailsFragment = DetailsFragment()
    }
}