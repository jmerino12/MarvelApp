package com.jmb.marvelapp.ui.characterdetail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.jmb.domain.aggregates.Character
import com.jmb.marvelapp.databinding.FragmentCharacterDetailBinding
import com.jmb.marvelapp.ui.common.UiState
import com.jmb.marvelapp.ui.common.loadUrl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterDetailFragment : Fragment() {

    private var _binding: FragmentCharacterDetailBinding? = null
    private val binding get() = _binding!!

    private val model: DetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCharacterDetailBinding.inflate(inflater, container, false)
        model.getSeries()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        model.data.observe(viewLifecycleOwner, (::updateUi))
    }

    private fun updateUi(uiState: UiState<Character>) {

        binding.loading.visibility = if (uiState is UiState.Loading) View.VISIBLE else View.GONE
        when (uiState) {
            is UiState.Success -> {
                binding.image.loadUrl("${uiState.data.thumbnail.path}/portrait_incredible.${uiState.data.thumbnail.extension}")
                binding.name.text = uiState.data.name
                binding.description.text =
                    if (uiState.data.description.isEmpty()) "No description" else uiState.data.description
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