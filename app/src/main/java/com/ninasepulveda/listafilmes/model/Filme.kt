package com.ninasepulveda.listafilmes.model

data class Filme(
    val id: Int,
    val titulo : String,
    val descricao : String,
    val diretor : String,
    val assistido : Boolean = false
)