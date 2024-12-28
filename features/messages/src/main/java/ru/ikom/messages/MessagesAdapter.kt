package ru.ikom.messages

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.ikom.messages.databinding.ItemMessageBinding

class MessagesAdapter(
    private val onClick: (String) -> Unit
) : ListAdapter<Message, MessagesAdapter.ViewHolder>(DiffMessages()) {

    inner class ViewHolder(
        private val binding: ItemMessageBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onClick(getItem(position).message)
                }
            }
        }

        fun bind(item: Message) {
            binding.message.text = item.message
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            ItemMessageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

data class Message(
    val id: Int,
    val message: String
)

private class DiffMessages : DiffUtil.ItemCallback<Message>() {
    override fun areItemsTheSame(oldItem: Message, newItem: Message): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Message, newItem: Message): Boolean =
        oldItem == newItem

}