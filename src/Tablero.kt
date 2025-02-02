class Tablero(val dimensiones: Int) {

    val tablero = generarTablero(dimensiones)

    companion object{
       private fun generarTablero(dimensiones: Int): MutableList<MutableList<String>>{
            val tablero = mutableListOf<MutableList<String>>()
            for (filas in 1..dimensiones) {
                val filaTablero = mutableListOf<String>()
                for (columnas in 1..dimensiones ) {
                    filaTablero.add("-")
                }
                tablero.add(filaTablero)
            }
            return tablero
        }

    }


    fun mostrarTablero(){
        for(fila in tablero){
            println(fila)
        }
    }


}