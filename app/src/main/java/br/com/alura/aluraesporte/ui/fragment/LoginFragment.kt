package br.com.alura.aluraesporte.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.alura.aluraesporte.R
import br.com.alura.aluraesporte.ui.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.login.login_botao_cadastro_usuario
import kotlinx.android.synthetic.main.login.login_botao_logar
import org.koin.android.viewmodel.ext.android.viewModel

class LoginFragment : Fragment() {

    private val navController by lazy { findNavController() }
    private val viewModel: LoginViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.login, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configuraBotaoLogin()
        configuraBotaoCadastrar()
    }

    private fun configuraBotaoCadastrar() {
        login_botao_cadastro_usuario.setOnClickListener {
            val direction = LoginFragmentDirections.acaoLoginParaCadastroUsuario()
            navController.navigate(direction)
        }
    }

    private fun configuraBotaoLogin() {
        login_botao_logar.setOnClickListener {
            viewModel.loga()
            vaiParaListaProdutos()
        }
    }

    private fun vaiParaListaProdutos() {
        val direction = LoginFragmentDirections.acaoLoginParaListaProdutos()
        navController.navigate(direction)
    }

}