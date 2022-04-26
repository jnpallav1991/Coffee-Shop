package com.envoy.coffeeshop.ui.business

import androidx.fragment.app.viewModels
import androidx.paging.LoadState
import androidx.recyclerview.widget.DividerItemDecoration
import com.envoy.coffeeshop.R
import com.envoy.coffeeshop.base.BaseFragment
import com.envoy.coffeeshop.databinding.FragmentBusinessBinding
import com.envoy.coffeeshop.ui.adapter.BusinessAdapter
import com.envoy.coffeeshop.utils.PagingLoadStateAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

@AndroidEntryPoint
class BusinessFragment :
    BaseFragment<FragmentBusinessBinding, BusinessViewModel>() {

    private val businessViewModel: BusinessViewModel by viewModels()

    override val layoutId: Int
        get() = R.layout.fragment_business

    @Inject
    lateinit var adapter: BusinessAdapter

    override fun getVM(): BusinessViewModel {
        return businessViewModel
    }

    override fun bindVM(binding: FragmentBusinessBinding, vm: BusinessViewModel) =
        with(binding) {
            with(adapter) {
                rvResult.apply {
                    postponeEnterTransition()
                    viewTreeObserver.addOnPreDrawListener {
                        startPostponedEnterTransition()
                        true
                    }
                }
                rvResult.adapter = withLoadStateHeaderAndFooter(
                    header = PagingLoadStateAdapter(this),
                    footer = PagingLoadStateAdapter(this)
                )
                swipeRefresh.setOnRefreshListener { refresh() }
                rvResult.addItemDecoration(
                    DividerItemDecoration(
                        rvResult.context,
                        DividerItemDecoration.VERTICAL
                    )
                )
                with(vm) {
                    launchOnLifecycleScope {
                        searchResult.collectLatest {
                            submitData(it)
                        }
                    }
                    launchOnLifecycleScope {
                        loadStateFlow.collectLatest {
                            swipeRefresh.isRefreshing = it.refresh is LoadState.Loading
                        }
                    }

                }
            }
        }

//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }

}