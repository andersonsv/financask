package br.com.alura.financask.adapter

import android.content.Context
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import br.com.alura.financask.R
import br.com.alura.financask.extension.formataParaBrasileiro
import br.com.alura.financask.extension.limitaAte
import br.com.alura.financask.model.Tipo
import br.com.alura.financask.model.Transacao
import kotlinx.android.synthetic.main.transacao_item.view.transacao_categoria
import kotlinx.android.synthetic.main.transacao_item.view.transacao_data
import kotlinx.android.synthetic.main.transacao_item.view.transacao_icone
import kotlinx.android.synthetic.main.transacao_item.view.transacao_valor

class ListaTransacoesAdapter(context: Context, transacoes: List<Transacao>) : BaseAdapter() {

    private val mTransacoes = transacoes
    private val mContext = context
    private val LIMITE_DA_CATEGORIA = 14

    override fun getView(posicao: Int, view: View?, parent: ViewGroup?): View {
        val viewCriada = LayoutInflater.from(mContext).inflate(R.layout.transacao_item, parent, false)

        val transacao = mTransacoes[posicao]

        if (transacao.tipo == Tipo.RECEITA) {
            viewCriada.transacao_valor.setTextColor(ContextCompat.getColor(mContext, R.color.receita))
            viewCriada.transacao_icone.setBackgroundResource(R.drawable.icone_transacao_item_receita)
        } else {
            viewCriada.transacao_valor.setTextColor(ContextCompat.getColor(mContext, R.color.despesa))
            viewCriada.transacao_icone.setBackgroundResource(R.drawable.icone_transacao_item_despesa)
        }

""
        viewCriada.transacao_valor.text = transacao.valor.formataParaBrasileiro()

        viewCriada.transacao_categoria.text = transacao.categoria.limitaAte(LIMITE_DA_CATEGORIA)
        viewCriada.transacao_data.text = transacao.data.formataParaBrasileiro()

        return viewCriada
    }

    override fun getItem(posicao: Int): Transacao {
        return mTransacoes[posicao]
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return mTransacoes.size
    }


}