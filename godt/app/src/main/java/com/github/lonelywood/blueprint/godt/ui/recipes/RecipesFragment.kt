package com.github.lonelywood.blueprint.godt.ui.recipes

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.github.lonelywood.blueprint.godt.R

class RecipesFragment : Fragment() {
    private lateinit var viewModel: RecipesViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.recipes_fragment, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RecipesViewModel::class.java)
        // TODO: Use the ViewModel
    }
}