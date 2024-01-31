package br.com.alura.aluraesporte.repository

import android.content.SharedPreferences
import androidx.core.content.edit

private const val CHAVE_LOGADO = "LOGADO"

class LoginRepository(private val preferences: SharedPreferences) {
    fun estaLogado(): Boolean = preferences.getBoolean(CHAVE_LOGADO, false)

    fun loga() = salva(estado = true)

    fun deslogar() = salva(estado = false)

    private fun salva(estado: Boolean) = preferences.edit { putBoolean(CHAVE_LOGADO, estado) }

}