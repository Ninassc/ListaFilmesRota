package com.ninasepulveda.listafilmes.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.ninasepulveda.listafilmes.model.Filme
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue

class FilmeViewModel : ViewModel(){
    var estaLogado by mutableStateOf(false)
        private set

    var filmes = mutableStateListOf(
        Filme(
            id = 1,
            titulo = "Jogos Vorazes",
            descricao = "Jovens dos distritos são colocados em arenas na capital para disputarem valendo a vida",
            diretor = "Gary Ross"
        ),
        Filme(
            id = 2,
            titulo = "O Senhor dos Anéis: A Sociedade do Anel",
            descricao = "Um hobbit recebe a missão de destruir um anel poderoso para salvar a Terra Média",
            diretor = "Peter Jackson"
        ),
        Filme(
            id = 3,
            titulo = "A Origem",
            descricao = "Um ladrão que invade os sonhos das pessoas recebe a tarefa de plantar uma ideia na mente de um alvo",
            diretor = "Christopher Nolan"
        ),
        Filme(
            id = 4,
            titulo = "Interstellar",
            descricao = "Um grupo de exploradores viaja através de um buraco de minhoca em busca de um novo lar para a humanidade",
            diretor = "Christopher Nolan"
        ),
        Filme(
            id = 5,
            titulo = "Matrix",
            descricao = "Um jovem programador descobre que a realidade é uma simulação computadorizada",
            diretor = "Lana e Lilly Wachowski"
        )
    )

    fun fazerLogin() {
        estaLogado = true
    }

    fun fazerLogout() {
        estaLogado = false
    }

    fun alternarConclusao(filmeId: Int) {
        val index = filmes.indexOfFirst { it.id == filmeId }
        if (index != -1) {
            filmes[index] = filmes[index].copy(assistido = !filmes[index].assistido)
        }
    }

    fun buscarFilme(filmeId: Int): Filme? =
        filmes.find { it.id == filmeId }
}