package com.jmb.marvelapp.ui.character

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.jmb.domain.aggregates.Character
import com.jmb.marvelapp.databinding.FragmentCharacterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterFragment : Fragment() {

    private var _binding: FragmentCharacterBinding? = null
    private val binding get() = _binding!!

    private val model: CharacterViewModel by viewModels()
    private val adapter: CharacterAdapter = CharacterAdapter(::navigateToDetail)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCharacterBinding.inflate(inflater, container, false)
        model.getSeries()
        binding.rvCharacter.adapter = adapter
        model.data.observe(viewLifecycleOwner, {
            adapter.submitList(it)
        })
        return binding.root
    }

    private fun navigateToDetail(character: Character) {
        findNavController().navigate(
            CharacterFragmentDirections.actionCharacterFragmentToCharacterDetailFragment(
                character.id
            )
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}