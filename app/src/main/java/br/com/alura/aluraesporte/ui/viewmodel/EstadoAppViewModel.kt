package br.com.alura.aluraesporte.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EstadoAppViewModel : ViewModel() {

    val componentesVisuais: LiveData<ComponentesVisuais> get() = _componentesVisuais

    private var _componentesVisuais: MutableLiveData<ComponentesVisuais> =
        MutableLiveData<ComponentesVisuais>().also { it.value = temComponentesVisuais }

    var temComponentesVisuais: ComponentesVisuais = ComponentesVisuais()
        set(value) {
            field = value
            _componentesVisuais.value = value
        }
}

class ComponentesVisuais(
    val appBar: Boolean = false,
    val bottomNavigation: Boolean = false
)