package com.ninasepulveda.listafilmes.userinterface

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.RadioButtonUnchecked
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ninasepulveda.listafilmes.model.Filme
import com.ninasepulveda.listafilmes.model.Rota
import com.ninasepulveda.listafilmes.viewmodel.FilmeViewModel

@Composable
fun ListaFilmesScreen(
    modifier: Modifier = Modifier,
    viewModel: FilmeViewModel,
    aoAbrirDetalhe: (Int) -> Unit
) {
    Column(modifier = modifier.fillMaxSize()) {
        Text(
            "Seus Filmes",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(20.dp)
        )

        if (viewModel.filmes.isEmpty()) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("Nenhum Filme Disponível.", color = MaterialTheme.colorScheme.secondary)
            }
        } else {
            LazyColumn(
                contentPadding = PaddingValues(horizontal = 20.dp, vertical = 4.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(viewModel.filmes, key = { it.id }) { filme ->
                    CardHabito(
                        filme = filme,
                        aoClicar = { aoAbrirDetalhe(filme.id) },
                        aoAlternar = { viewModel.alternarConclusao(filme.id) }
                    )
                }
            }
        }
    }
}

@Composable
private fun CardHabito(filme: Filme, aoClicar: () -> Unit, aoAlternar: () -> Unit) {
    Card(
        onClick = aoClicar,
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(filme.titulo, fontWeight = FontWeight.SemiBold)
                Spacer(Modifier.width(5.dp))

                Text(filme.descricao, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.secondary)
                Spacer(Modifier.width(5.dp))

                Text(filme.diretor, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.secondary)
            }
            IconButton(onClick = aoAlternar) {
                Icon(
                    imageVector = if (filme.assistido) Icons.Filled.CheckCircle else Icons.Filled.RadioButtonUnchecked,
                    contentDescription = if (filme.assistido) "Concluído hoje, tocar para desmarcar" else "Marcar como concluído",
                    tint = if (filme.assistido) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary
                )
            }
        }
    }
}