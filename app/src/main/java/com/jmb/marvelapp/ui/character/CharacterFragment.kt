package com.jmb.marvelapp.ui.character

import android.os.Bundle
import android.text.InputType
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.jmb.domain.aggregates.Character
import com.jmb.marvelapp.R
import com.jmb.marvelapp.databinding.FragmentCharacterBinding
import dagger.hilt.android.AndroidEntryPoint
import java.lang.Exception

@AndroidEntryPoint
class CharacterFragment : Fragment() {

    private var _binding: FragmentCharacterBinding? = null
    private val binding get() = _binding!!

    private val model: CharacterViewModel by viewModels()
    private val adapter: CharacterAdapter = CharacterAdapter(::navigateToDetail)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCharacterBinding.inflate(inflater, container, false)
        model.getSeries()
        binding.rvCharacter.adapter = adapter
        model.data.observe(viewLifecycleOwner, {
            adapter.listCharactersCopy = it
            adapter.mListRef = it
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

    private fun search(searchView: SearchView) {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                (binding.rvCharacter.adapter as CharacterAdapter).filter.filter(newText)
                return true
            }
        })
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_topbar, menu)
        val mSearchMenuItem = menu.findItem(R.id.search)
        val searchView = mSearchMenuItem.actionView as SearchView
        search(searchView)
        super.onCreateOptionsMenu(menu, inflater)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}