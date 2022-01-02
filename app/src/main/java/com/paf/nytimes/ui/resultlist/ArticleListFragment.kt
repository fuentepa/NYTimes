package com.paf.nytimes.ui.resultlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.paf.nytimes.R
import com.paf.nytimes.databinding.FragmentArticleListBinding
import com.paf.nytimes.ui.BaseActivity
import com.paf.nytimes.ui.search.SearchViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ArticleListFragment : Fragment() {

    private val vm: ArticleListViewModel by viewModel()
    private var _binding: FragmentArticleListBinding? = null
    private val binding get() = _binding!!

    private val args: ArticleListFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentArticleListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupObservers()
    }

    private fun setupObservers(){
        lifecycleScope.launchWhenStarted {
            vm.loading.collect {
                if (it)
                    (activity as BaseActivity).mostrarProgressBar()
                else
                    (activity as BaseActivity).ocultarProgressBar()
            }
        }
    }


    override fun onResume() {
        super.onResume()
        //TODO llamar al vm para que consulte la lista con los parametros que nos han llegado.
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}