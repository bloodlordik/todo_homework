package ru.kirshov.todohomework.presentation.fargments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import org.koin.androidx.navigation.koinNavGraphViewModel
import ru.kirshov.todohomework.R
import ru.kirshov.todohomework.databinding.FragmentMainBinding
import ru.kirshov.todohomework.domain.MainViewModel

class MainFragment:Fragment(R.layout.fragment_main) {
    private var _binding: FragmentMainBinding? = null
    private val binding:FragmentMainBinding get() = _binding!!
    private val navController:NavController by lazy { findNavController() }
    private val mainViewModel by koinNavGraphViewModel<MainViewModel>(R.id.navigation_graf)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMainBinding.bind(view)
         binding.fab.setOnClickListener {

            navController.navigate(R.id.action_mainFragment_to_detailFragment)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}