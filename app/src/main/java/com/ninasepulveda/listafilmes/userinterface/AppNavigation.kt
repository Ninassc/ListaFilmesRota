package com.ninasepulveda.listafilmes.userinterface

import androidx.compose.runtime.Composable
import androidx.compose.runtime.internal.composableLambda
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.ninasepulveda.listafilmes.model.Rota
import com.ninasepulveda.listafilmes.viewmodel.FilmeViewModel

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val viewModel: FilmeViewModel = viewModel()

    NavHost(navController = navController, startDestination = Rota.Login) {
        composable<Rota.Splash> {
            SplashScreen(
                estaLogado = viewModel.estaLogado,
                aoTerminarVerificacao = { logado ->
                    val destino = if (logado) Rota.ListaFilmes else Rota.Login
                    navController.navigate(destino) {
                        popUpTo(Rota.Splash) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable<Rota.Login> {
            LoginScreen(
                aoLogar = {
                    viewModel.fazerLogin()
                    navController.navigate(Rota.ListaFilmes) {
                        popUpTo(Rota.Login) { inclusive = true }
                    }
                }
            )
        }

        composable<Rota.ListaFilmes> {
            PainelPrincipal(navController = navController, viewModel, AbaPrincipal.FILMES)
        }

        composable<Rota.Perfil> {
            PainelPrincipal(navController = navController, viewModel, AbaPrincipal.PERFIL)
        }

        composable<Rota.DetalheFilme> { backStackEntry ->
            val rota: Rota.DetalheFilme = backStackEntry.toRoute()
            DetalheFilmeScreen(
                filme = viewModel.buscarFilme(rota.filmeId),
                aoVoltar = { navController.popBackStack() },
                aoAlternarConclusao = { viewModel.alternarConclusao(rota.filmeId) }
            )
        }
    }
}