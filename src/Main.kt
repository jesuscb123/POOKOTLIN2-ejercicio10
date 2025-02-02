
fun pedirPosiciones(): Pair<Int,Int> {
    var posicionesCorrectas = false
    var fila = 0
    var columna = 0
    while(!posicionesCorrectas){
        try {
            print("Introduce la posición fila: ")
            fila = readln().toInt()
            print("Introduce la posición columna: ")
            columna = readln().toInt()
            if (fila < 0 || columna < 0){
                throw IllegalArgumentException("Error, introduce un número positivo")
            }
            if (fila !in 1..3 || columna !in 1..3){
                throw IllegalArgumentException("Error, debes introducir un número del 1 al 3.")
            }
            posicionesCorrectas = true
        }catch (e: NumberFormatException){
            println("Error, introduce un número")
        }catch (e: IllegalArgumentException){
            println("Error, introduce un número positivo")
        }
    }
    return Pair(fila -1,columna -1)

}


fun turnoJugador(partida: Jugar, signo: String): Boolean{
    var terminaTurno = false
    while (!terminaTurno){
        if(signo == "X"){
            println("Turno jugador1")
            val (fila,columna) = pedirPosiciones()
            if(partida.ponerSigno(fila,columna, "X")) {
                terminaTurno = true
            }

            }else if(signo == "O"){
                println("Turno jugador2")
                val (fila,columna) = pedirPosiciones()
                if(partida.ponerSigno(fila,columna, "O")){
                    terminaTurno = true
                }
            }
        }
    return true
    }



fun comprobarGanador(partida: Jugar): Boolean{
    var (ganadorFila,signoFila) = partida.comprobarGanadorFila()
    var (ganadorColumna,signoColumna) = partida.comprobarGanadorColumna()
    if(!ganadorFila && signoFila == "-" || !ganadorColumna && signoColumna == "-"){
        return false
    }
    return true
}

fun iniciarJuego(partida: Jugar): Boolean {
    var partidaFinalizada = false
    while (!partidaFinalizada) {
        partida.tablero.mostrarTablero()
        var turnoJugador = "jugador1"
        while (turnoJugador == "jugador1" && !partidaFinalizada) {
            if (turnoJugador(partida, partida.jugador1.signo)) {
                if (comprobarGanador(partida)) {
                    partida.tablero.mostrarTablero()
                    println("Ha ganado el jugador 1")
                    partidaFinalizada = true
                }else{
                    turnoJugador = "jugador2"
                }

            }
        }
        while (turnoJugador == "jugador2" && !partidaFinalizada){
            partida.tablero.mostrarTablero()
            if (turnoJugador (partida, partida.jugador2.signo)){
                if (comprobarGanador(partida)){
                    partida.tablero.mostrarTablero()
                    println("Ha ganado el jugador2")
                    partidaFinalizada = true
                }else{
                    turnoJugador = "jugador1"
                }

            }
        }
    }
    return true
}









fun main() {
    val tablero1 = Tablero(3)
    val jugador1 = Jugador("X")
    val jugador2 = Jugador("O")
    val partida1 = Jugar(jugador1,jugador2,tablero1)
    iniciarJuego(partida1)

}