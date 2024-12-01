package id.ac.polbeng.adindaoktavia.kabupatenkotariauapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import id.ac.polbeng.adindaoktavia.kabupatenkotariauapp.databinding.ActivityViewPetaBinding

class ViewPetaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityViewPetaBinding
    companion object {
        const val EXTRA_URL_PETA = "extra_url_peta"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewPetaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val urlPeta = intent.getStringExtra(EXTRA_URL_PETA)
        val requestBuilder = GlideToVectorYou
            .init()
            .with(this)
            .requestBuilder
        requestBuilder
            .load(urlPeta)
            .transition(DrawableTransitionOptions.withCrossFade())
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.ic_baseline_image_24)
                    .error(R.drawable.ic_baseline_broken_image_24)
                    .fitCenter()
            )
            .into(binding.imgItemPhoto)
    }
}


