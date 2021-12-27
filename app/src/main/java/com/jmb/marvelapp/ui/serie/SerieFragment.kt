package com.jmb.marvelapp.ui.serie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import com.jmb.domain.aggregates.Serie
import com.jmb.marvelapp.databinding.FragmentSerieBinding
import com.jmb.marvelapp.ui.common.UiState
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.FragmentScoped

@AndroidEntryPoint
class SerieFragment : Fragment() {

    private var _binding: FragmentSerieBinding? = null
    private val binding get() = _binding!!

    private val model: SerieViewModel by viewModels()
    private val adapter: SerieAdapter = SerieAdapter()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSerieBinding.inflate(inflater, container, false)
        model.getSeries()
        binding.rvSeries.adapter = adapter
        model.data.observe(viewLifecycleOwner, ::updateUi)
        return binding.root
    }

    private fun updateUi(uiState: UiState<List<Serie>>) {
        binding.loading.visibility = if (uiState is UiState.Loading) View.VISIBLE else View.GONE
        when (uiState) {
            is UiState.Success -> {
                adapter.submitList(uiState.data)
            }
            is UiState.Error -> {
                Toast.makeText(context, uiState.error.toString(), Toast.LENGTH_SHORT).show()
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}