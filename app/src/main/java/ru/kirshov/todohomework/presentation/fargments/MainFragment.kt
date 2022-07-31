package ru.kirshov.todohomework.presentation.fargments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import org.koin.androidx.navigation.koinNavGraphViewModel
import ru.kirshov.todohomework.R
import ru.kirshov.todohomework.databinding.FargmentMainBinding
import ru.kirshov.todohomework.domain.MainViewModel

class MainFragment:Fragment(R.layout.fargment_main) {
    private val navController:NavController by lazy { findNavController() }
    private val mainViewModel by koinNavGraphViewModel<MainViewModel>(R.id.navigation_graf)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}