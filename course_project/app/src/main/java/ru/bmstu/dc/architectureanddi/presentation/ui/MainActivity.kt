package ru.bmstu.dc.architectureanddi.presentation.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import ru.bmstu.dc.architectureanddi.R

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.users
            .onEach { users ->
                Log.d(javaClass.simpleName, users.toString())
            }
            .launchIn(lifecycleScope)

        lifecycleScope.launch {
            viewModel.authenticate()
            viewModel.update()
        }
    }
}