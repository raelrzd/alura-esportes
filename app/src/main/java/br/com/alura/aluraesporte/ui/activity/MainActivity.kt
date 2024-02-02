package br.com.alura.aluraesporte.ui.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import br.com.alura.aluraesporte.R
import br.com.alura.aluraesporte.ui.viewmodel.EstadoAppViewModel
import kotlinx.android.synthetic.main.main_activity.main_activity_bottom_navigation
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: EstadoAppViewModel by viewModel()
    private val navController by lazy { findNavController(R.id.main_activity_nav_host_fragment) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        eventosDeNavegacaoListener()
        main_activity_bottom_navigation.setupWithNavController(navController)
    }

    private fun eventosDeNavegacaoListener() {
        navController.addOnDestinationChangedListener { navController, navDestination, bundle ->
            title = navDestination.label
            configuraComponentesVisuais()
        }
    }

    private fun configuraComponentesVisuais() {
        viewModel.componentesVisuais.observe(this, Observer {
            it?.let { temComponentes ->
                if (temComponentes.appBar) supportActionBar?.show()
                else supportActionBar?.hide()

                main_activity_bottom_navigation.visibility =
                    if (temComponentes.bottomNavigation) View.VISIBLE else View.GONE
            }
        })
    }

}
