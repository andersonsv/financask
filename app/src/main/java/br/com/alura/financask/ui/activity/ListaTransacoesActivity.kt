package br.com.alura.financask.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.alura.financask.R
import br.com.alura.financask.adapter.ListaTransacoesAdapter
import br.com.alura.financask.model.Tipo
import br.com.alura.financask.model.Transacao
import kotlinx.android.synthetic.main.activity_lista_transacoes.lista_transacoes_listview
import java.math.BigDecimal
import java.util.Calendar

class ListaTransacoesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_lista_transacoes)

        val transacoes = listOf(
            Transacao(
                categoria = "Almoço de final de semana",
                tipo = Tipo.DESPESA,
                data = Calendar.getInstance(),
                valor = BigDecimal(20.5)
            ),
            Transacao(
                valor = BigDecimal(100.0),
                tipo = Tipo.RECEITA,
                categoria = "Economia"
            ),
            Transacao(
                valor = BigDecimal(200.0),
                tipo = Tipo.DESPESA
            ),
            Transacao(
                valor = BigDecimal(500.0),
                categoria = "Prêmio",
                tipo = Tipo.RECEITA
            )
        )

        lista_transacoes_listview.adapter = ListaTransacoesAdapter(this, transacoes)
    }
}