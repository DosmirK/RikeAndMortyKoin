package com.example.rikeandmortykoin.ui.characters

import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rikeandmortykoin.databinding.FragmentCharactersListBinding
import com.example.rikeandmortykoin.ui.base.BaseFragment
import com.example.rikeandmortykoin.ui.characters.adapter.CharactersPagingAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class CharactersListFragment: BaseFragment<
        FragmentCharactersListBinding, CharactersViewModel>(FragmentCharactersListBinding::inflate) {

    override val viewModel: CharactersViewModel by viewModel()
    private val charactersAdapter = CharactersPagingAdapter(this::onClicker)

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
        viewModel.characterList.observe(viewLifecycleOwner) {
            charactersAdapter.submitData(viewLifecycleOwner.lifecycle, it)
        }
        lifecycleScope.launch {
            charactersAdapter.loadStateFlow.collectLatest {
                binding.animLoading.isVisible =
                    (it.refresh is LoadState.Loading) || (it.append is LoadState.Loading)
            }
        }
    }
    private fun onClicker(character: Int){
        findNavController().navigate(CharactersListFragmentDirections.actionCharactersListFragmentToCharacterDetailFragment(character))
    }
}