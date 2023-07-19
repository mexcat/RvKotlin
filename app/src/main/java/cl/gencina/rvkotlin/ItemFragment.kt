package cl.gencina.rvkotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cl.gencina.rvkotlin.databinding.FragmentItemBinding

class ItemFragment : Fragment() {
    private lateinit var binding: FragmentItemBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentItemBinding.inflate(requireActivity().layoutInflater, container, false)
        initAdapter()
        return binding.root
    }

    fun initAdapter(){
        val adapter = MyItemRecyclerViewAdapter()
        adapter.setData(Pokedex.getPokedex())
        binding.rvList.adapter = adapter
    }
    
}