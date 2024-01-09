package com.josequal.josequaltask.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.josequal.josequaltask.databinding.FragmentHomeBinding
import com.josequal.josequaltask.fragments.home.adapters.ContactsAdapter
import com.josequal.josequaltask.fragments.home.adapters.InformationAdapter
import com.josequal.josequaltask.fragments.home.adapters.SeasAdapter
import com.josequal.josequaltask.fragments.home.adapters.SelectorAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModels()
    private lateinit var informationAdapter: InformationAdapter
    private lateinit var contactsAdapter: ContactsAdapter
    private lateinit var selectorAdapter: SelectorAdapter
    private lateinit var seasAdapter: SeasAdapter

    lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setInformationAdapter()
        setContactsAdapter()
        setSelectorAdapter()
        setSeasAdapter()
    }

    private fun setInformationAdapter() {
        informationAdapter = InformationAdapter()
        informationAdapter.submitList(viewModel.getInformation())
        binding.rvHomeInfo.adapter = informationAdapter
    }

    private fun setContactsAdapter() {
        contactsAdapter = ContactsAdapter()
        contactsAdapter.submitList(viewModel.getContacts())
        binding.rvHomeContacts.adapter = contactsAdapter
    }

    private fun setSelectorAdapter() {
        selectorAdapter = SelectorAdapter()
        selectorAdapter.submitList(viewModel.getSelectors())
        binding.rvHomeSelector.adapter = selectorAdapter
    }

    private fun setSeasAdapter() {
        seasAdapter = SeasAdapter()
        seasAdapter.submitList(viewModel.getSeas())
        binding.rvHomeSeas.adapter = seasAdapter
    }
}