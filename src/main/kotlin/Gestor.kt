var nivel_actual: Int = 0

var estado_acual: Estados = Estados.Idle

var nivel_destino: Int = 0

fun gestor(): Int {
    when (estado_acual) {
        Estados.Idle -> {
            if (nivel_actual != 0 && nivel_actual != 1) {
                nivel_actual = -1
                estado_acual = Estados.Error
            }
        }

        Estados.MovingUP -> {
            nivel_actual = 2
        }

        Estados.MovingDOWN -> {
            nivel_actual = 2
        }

        Estados.Error -> {
            nivel_actual = -1
        }
    }

    return nivel_actual
}