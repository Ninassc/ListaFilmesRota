package com.ninasepulveda.listafilmes.userinterface

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ninasepulveda.listafilmes.model.Filme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetalheFilmeScreen(filme : Filme?, aoVoltar: () -> Unit, aoAlternarConclusao: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(filme?.titulo ?: "Filme") },
                navigationIcon = {
                    IconButton(onClick = aoVoltar) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Voltar")
                    }
                }
            )
        }
    ) { padding ->
        if (filme == null) {
            Box(Modifier.fillMaxSize().padding(padding), contentAlignment = Alignment.Center) {
                Text("Hábito não encontrado.")
            }
            return@Scaffold
        }
        Column(
            modifier = Modifier.fillMaxSize().padding(padding).padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(filme.titulo, style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(8.dp))

            Text("Meta: ${filme.descricao}", style = MaterialTheme.typography.bodyLarge)
            Spacer(Modifier.height(8.dp))

            Text("Meta: ${filme.diretor}", style = MaterialTheme.typography.bodyLarge)
            Spacer(Modifier.height(32.dp))

            Button(onClick = aoAlternarConclusao) {
                Text(if (filme.assistido) "Desmarcar conclusão" else "Marcar como concluído hoje")
            }
        }
    }
}