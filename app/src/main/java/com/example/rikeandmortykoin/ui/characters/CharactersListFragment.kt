package com.example.rikeandmortykoin.ui.characters

import androidx.core.view.isVisible
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rikeandmortykoin.databinding.FragmentCharactersListBinding
import com.example.rikeandmortykoin.ui.base.BaseFragment
import com.example.rikeandmortykoin.ui.characters.adapter.CharacterAdapter
import com.example.rikeandmortykoin.utils.Resource
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class CharactersListFragment: BaseFragment<
        FragmentCharactersListBinding, CharactersViewModel>(FragmentCharactersListBinding::inflate) {

    override val viewModel: CharactersViewModel by viewModel()
    private val charactersAdapter = CharacterAdapter(this::onClicker)

    override fun setupViews() {
        super.setupViews()
        with(binding.characterRv) {
            adapter = charactersAdapter
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.VERTICAL,
                false
            )
        }
    }
    override fun observe() {
        super.observe()
        viewModel.viewModelScope.launch {
            viewModel.giveCharacters().stataHandler(
                success = {
                    charactersAdapter.submitList(it)
                },
                state = {
                    binding.animLoading.isVisible = it is Resource.Loading
                }
            )
        }
    }
    private fun onClicker(character: Int){
        findNavController().navigate(CharactersListFragmentDirections.actionCharactersListFragmentToCharacterDetailFragment(character))
    }
}