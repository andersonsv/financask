package br.com.alura.financask.extension

fun String.limitaAte(caracteres: Int) : String{
    if (this.length > caracteres) {
        return  "${this.substring(0, caracteres)}..."
    }
    return this
}
