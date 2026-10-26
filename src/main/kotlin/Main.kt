fun main() {
    println("Nivel inicial: ${gestor()}")

    println("Pulsamos nivel_1")
    nivel_1()
    println("Nivel actual: ${gestor()}")

    finalizarMovimiento()
    println("Nivel después de subir: ${gestor()}")

    println("Pulsamos nivel_0")
    nivel_0()
    println("Nivel actual: ${gestor()}")

    finalizarMovimiento()
    println("Nivel después de bajar: ${gestor()}")
}
