package ru.kirshov.todohomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.kirshov.todohomework.domain.MainViewModel

class MainActivity : AppCompatActivity() {
    private val viewMainModel:MainViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}