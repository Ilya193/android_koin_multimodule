package ru.ikom.messages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import ru.ikom.messages.databinding.DetailsFragmentBinding

class DetailsFragment : BottomSheetDialogFragment() {

    private var _binding: DetailsFragmentBinding? = null
    private val binding: DetailsFragmentBinding get() = _binding!!

    private var name = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        name = requireArguments().getString(NAME_KEY, "")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DetailsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.name.text = name
    }

    fun setArguments(name: String): DetailsFragment {
        arguments = bundleOf(NAME_KEY to name)
        return this
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val NAME_KEY = "name_key"
    }
}