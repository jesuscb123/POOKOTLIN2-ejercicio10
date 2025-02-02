    class Jugar(val jugador1: Jugador, val jugador2: Jugador, tablero: Tablero) {

    val tablero = tablero

    fun ponerSigno(fila: Int, columna: Int, signo: String): Boolean{
        if(tablero.tablero[fila][columna] == "-"){
            tablero.tablero[fila][columna] = signo
        }else{
            return false
        }
        return true
    }

        fun comprobarGanadorColumna(): Pair<Boolean,String>{
            for(columna in 0..tablero.tablero.size -1){
                var contadorj1 = 0
                var contadorj2 = 0
                for (fila in 0..tablero.tablero.size -1){
                    if (tablero.tablero[fila][columna] == "X"){
                        contadorj1 ++
                        println("Columna sumada: $contadorj1")
                        if(contadorj1 == tablero.dimensiones){
                            println("DEBERIA DE GANAR JUGADOR1")
                            return Pair(true,"X")
                        }
                    }else if(tablero.tablero[fila][columna] == "O"){
                        contadorj2++
                        if (contadorj2 == tablero.tablero.size){
                            return Pair(true,"O")
                        }
                    }
                }
            }
            return Pair(false,"-")
        }

    fun comprobarGanadorFila(): Pair<Boolean,String>{

            for (fila in tablero.tablero){
                var contadorj1 = 0
                var contadorj2 = 0
                for(elemento in fila){
                    if (elemento == "X"){
                        contadorj1++
                        println("Fila sumada: $contadorj1")
                        if (contadorj1 == tablero.tablero.size)
                            return Pair(true,"X")
                    }else if(elemento == "O"){
                        contadorj2++
                        if (contadorj2 == tablero.tablero.size){
                            return Pair(true, "O")
                        }
                    }
                }
            }
            return Pair(false,"-")
        }






}