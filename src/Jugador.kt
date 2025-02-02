data class Jugador(val signo: String) {


    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Jugador) return false
        return this.signo == other.signo
    }



    override fun hashCode(): Int {
        return signo.hashCode()
    }
}