package br.com.alura.aluraesporte.ui.viewmodel

import androidx.lifecycle.ViewModel
import br.com.alura.aluraesporte.repository.LoginRepository

class LoginViewModel(private val repository: LoginRepository) : ViewModel() {

    fun loga() = repository.loga()

    fun estaLogado() = repository.estaLogado()

    fun naoEstaLogado() = !estaLogado()

    fun deslogar() = repository.deslogar()

}