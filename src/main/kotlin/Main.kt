fun main() {
    println("Nivel inicial: ${gestor()}")

    println("Pulsamos nivel 1")
    nivel_1()
    println("Nivel actual: ${gestor()}")

    finalizarMovimiento()
    println("Nivel después de subir: ${gestor()}")

    println("Pulsamos nivel 0")
    nivel_0()
    println("Nivel actual: ${gestor()}")

    finalizarMovimiento()
    println("Nivel después de bajar: ${gestor()}")
}
