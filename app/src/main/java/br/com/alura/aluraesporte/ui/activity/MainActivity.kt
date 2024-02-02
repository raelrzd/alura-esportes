package br.com.alura.aluraesporte.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import br.com.alura.aluraesporte.R
import br.com.alura.aluraesporte.ui.viewmodel.EstadoAppViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: EstadoAppViewModel by viewModel()
    private val navController by lazy { findNavController(R.id.main_activity_nav_host_fragment) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        navController.addOnDestinationChangedListener { navController, navDestination, bundle ->
            title = navDestination.label

            viewModel.appBar.observe(this, Observer {
                it?.let { temAppBar ->
                    if (temAppBar) supportActionBar?.show()
                    else supportActionBar?.hide()
                }
            })


        }

    }

}
