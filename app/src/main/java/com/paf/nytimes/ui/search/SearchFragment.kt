package com.paf.nytimes.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.paf.nytimes.R
import com.paf.nytimes.databinding.FragmentSearchBinding
import com.paf.nytimes.ui.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : Fragment() {

    private val vm: SearchViewModel by viewModel()
    private var _binding: FragmentSearchBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as BaseActivity).supportActionBar?.title =  resources.getString(R.string.title_articles_search)

        binding.spinnerType.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                vm.setSelectedType(position)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) { Unit }
        }

        binding.spinnerPeriod.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

            }

            override fun onNothingSelected(p0: AdapterView<*>?) { Unit }
        }

        //binding.cbFacebook.setOnClickListener { TODO("Not yet implemented") } //solo se indica facebook porque la api no soporta tweeter ahora

        binding.fab.setOnClickListener { findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment) }

        setupObservers()
    }

    private fun setupObservers(){
        lifecycleScope.launchWhenStarted {
            vm.facebookCbChecked.collect { binding.cbFacebook.isChecked = it }
        }

        lifecycleScope.launchWhenStarted {
            vm.facebookCbVisible.collect { binding.cbFacebook.isVisible = it}
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}