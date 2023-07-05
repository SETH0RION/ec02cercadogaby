package com.cercado.ec02

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.cercado.ec02.databinding.FragmentMapsBinding


class MapsFragment : Fragment(R.layout.fragment_maps) {

    private lateinit var binding: FragmentMapsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_maps, container, false)

        //val maps = MapsFragment()
        //val transactional = fragmentManager?.beginTransaction()
        //transactional?.replace(R.id.fragment_container_view_tag, maps)?.commit()
        val btnmap : Button = view.findViewById(R.id.map_button)
        btnmap.setOnClickListener {
            requireActivity().run{
                startActivity(Intent(this, ViewMapActivity::class.java))
            }
            Toast.makeText(view.context, "Look location", Toast.LENGTH_SHORT).show()
        }

        return view
    }

}