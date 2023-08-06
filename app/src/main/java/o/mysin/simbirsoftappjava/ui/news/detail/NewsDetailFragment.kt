package o.mysin.simbirsoftappjava.ui.news.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import coil.load
import o.mysin.simbirsoftappjava.R
import o.mysin.simbirsoftappjava.databinding.FragmentNewsDetailBinding
import o.mysin.simbirsoftappjava.domain.model.News
import o.mysin.simbirsoftappjava.utils.correctDateTime
import org.koin.androidx.viewmodel.ext.android.viewModel


class NewsDetailFragment : Fragment(R.layout.fragment_news_detail) {

    private val binding: FragmentNewsDetailBinding by viewBinding()
    private val newsDetailViewModel: NewsDetailViewModel by viewModel()
    private val args by navArgs<NewsDetailFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        newsDetailViewModel.news.observe(viewLifecycleOwner) { renderData(it) }
        newsDetailViewModel.getNews(args.newsId)

        initActionButtons()
        binding.labelNewsDetail.text = args.newsId.toString()

    }

    private fun renderData(news: News) {
        with(binding) {
            labelNewsDetailToolbar.text = news.name
            labelNewsDetail.text = news.name
            timeNewsDetail.text = correctDateTime(news.startDate, news.endDate)
            titleOwnerNewsDetail.text = news.organisation
            ownerAddress.text = news.address
            ownerContacts.text = news.phone
            firstImageNews.load(news.photos[0])
            secondImageNews.load(news.photos[1])
            thirdImageNews.load(news.photos[2])
            newsDescription.text = news.fullDescription
        }
    }


    private fun initActionButtons() {
        binding.newsDetailToolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }
}
