package com.sigit.a055_per7

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.sigit.a055_per7.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_BOOK = "extra_book"
    }

    private lateinit var binding: ActivityDetailBinding

    @Suppress("DEPRECATION")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val book = intent.getSerializableExtra(EXTRA_BOOK) as? Book
        book?.let {
            binding.ivCoverDetail.load(it.cover) {
                crossfade(true)
                placeholder(android.R.drawable.ic_menu_report_image)
            }
            binding.tvTitleDetail.text = it.title
            binding.tvOriginalTitleDetail.text = it.originalTitle
            binding.tvReleaseDateDetail.text = "Released: ${it.releaseDate}"
            binding.tvPagesDetail.text = "Pages: ${it.pages}"
            binding.tvDescriptionDetail.text = it.description
        }
    }
}