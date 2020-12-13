package com.peakfinn.madlevel6task1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_color.*

/**
 * Created by Finn Bon on 13/12/2020.
 */
class ColorFragment : Fragment() {

    private val colors = arrayListOf<ColorItem>()
    private lateinit var colorAdapter: ColorAdapter
    private val viewModel: ColorViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_color, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        colorAdapter = ColorAdapter(colors, ::onColorClick)
        rvColors.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        rvColors.adapter = colorAdapter

        observeColors()
    }

    private fun observeColors() {
        viewModel.colorItems.observe(viewLifecycleOwner, Observer {
            colors.clear()
            colors.addAll(it)
            colorAdapter.notifyDataSetChanged()
        })
    }

    private fun onColorClick(colorItem: ColorItem) {
        Snackbar.make(rvColors, "This color is: ${colorItem.name}", Snackbar.LENGTH_LONG).show()
    }

}