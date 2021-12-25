package com.jmb.marvelapp.ui.characterdetail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.jmb.domain.aggregates.Character
import com.jmb.marvelapp.databinding.FragmentCharacterDetailBinding
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

    private fun updateUi(character: Character) {

        binding.image.loadUrl("${character.thumbnail.path}/portrait_incredible.${character.thumbnail.extension}")
        binding.name.text = character.name
        binding.description.text =
            if (character.description.isEmpty()) "No description" else character.description
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}