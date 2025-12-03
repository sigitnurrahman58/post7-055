package com.sigit.a055_per7

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.sigit.a055_per7.databinding.ItemBooksBinding

data class BookAdapter(
    private val items: List<Book>,
    private val onItemClick: (Book) -> Unit
) : RecyclerView.Adapter<com.sigit.a055_per7.BookAdapter.BookViewHolder>() {

    inner class BookViewHolder(private val binding: ItemBooksBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(book: Book) {
            binding.tvTitleItem.text = book.title
            binding.tvReleaseDateItem.text = book.releaseDate
            binding.tvPagesItem.text = "${book.pages} pages"

            // Coil untuk load gambar (opsional)
            binding.ivCoverItem.load(book.cover) {
                crossfade(true)
                placeholder(android.R.drawable.ic_menu_report_image)
            }

            binding.root.setOnClickListener {
                onItemClick(book)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val binding = ItemBooksBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return BookViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) =
        holder.bind(items[position])

    override fun getItemCount(): Int = items.size
}

