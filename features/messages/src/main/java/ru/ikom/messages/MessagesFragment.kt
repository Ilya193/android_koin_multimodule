package ru.ikom.messages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import ru.ikom.domain.Repository

class MessagesFragment(
    private val repository: Repository,
    onOpenDetails: (String) -> Unit
) : Fragment() {

    private val viewModel: MessagesViewModel by viewModel {
        parametersOf(repository)
    }

    private val adapter = MessagesAdapter(onOpenDetails)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.messages_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val messages = view.findViewById<RecyclerView>(R.id.messages)

        messages.adapter = adapter
        messages.setHasFixedSize(true)

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.state.collect {
                adapter.submitList(it)
            }
        }
    }
}