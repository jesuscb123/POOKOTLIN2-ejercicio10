import javax.swing.text.StyledEditorKit.BoldAction
import javax.swing.text.StyledEditorKit.selectAllAction

class Jugar(val jugador1: Jugador, val jugador2: Jugador, tablero: Tablero) {

    val tablero = tablero

    fun ponerSigno(fila: Int, columna: Int, signo: String): Boolean {
        if (tablero.tablero[fila][columna] == "-") {
            tablero.tablero[fila][columna] = signo
        } else {
            return false
        }
        return true
    }

    fun comprobarGanadorColumna(): Boolean {
        for (columna in 0..tablero.tablero.size - 1) {
            var contadorj1 = 0
            var contadorj2 = 0
            for (fila in 0..tablero.tablero.size - 1) {
                if (tablero.tablero[fila][columna] == "X") {
                    contadorj1++
                    if (contadorj1 == tablero.dimensiones) {
                        return true
                    }
                } else if (tablero.tablero[fila][columna] == "O") {
                    contadorj2++
                    if (contadorj2 == tablero.tablero.size) {
                        return true
                    }
                }
            }
        }
        return false
    }

    fun comprobarGanadorFila(): Boolean {
        for (fila in tablero.tablero) {
            var contadorJ1 = 0
            var contadorJ2 = 0
            for (elemento in fila) {
                if (elemento == "X") {
                    contadorJ1++
                    if (contadorJ1 == tablero.tablero.size)
                        return true
                } else if (elemento == "O") {
                    contadorJ2++
                    println("Contador FILA JUGADOR 2: $contadorJ2")
                    if (contadorJ2 == tablero.tablero.size) {
                        return true
                    }
                }
            }
        }
        return false
    }

    fun comprobarGanadorDiagonal(): Boolean {
        var contadorJ1 = 0
        var contadorJ2 = 0
        for (i in 0..tablero.tablero.size - 1) {
            if (tablero.tablero[i][i] == "X") {
                contadorJ1++
                if (contadorJ1 == tablero.tablero.size) {
                    return true
                }
            } else if (tablero.tablero[i][i] == "O") {
                contadorJ2++
                if (contadorJ2 == tablero.tablero.size) {
                    return true
                }
            }
        }
        return false
    }

    fun comprobarGanadorDiagonalInvertida(): Boolean {
        var contadorJ1 = 0
        var contadorJ2 = 0
        for (fila in 0..tablero.tablero.size -1){
            for (columna in 0..tablero.tablero.size -1){
                if (fila + columna == tablero.tablero.size -1){
                    if (tablero.tablero[fila][columna] == "X"){
                        contadorJ1++
                        if (contadorJ1 == tablero.tablero.size) {
                            return true
                        }
                    }else if(tablero.tablero[fila][columna] == "0"){
                            contadorJ2++
                            if (contadorJ2 == tablero.tablero.size){
                                return true
                            }
                        }
                }
            }
        }
        return false
    }

}