var nivel_actual: Int = 0

var estado_acual: Estados = Estados.Idle

var nivel_destino: Int = 0

fun gestor(): Int {
    when (estado_acual) {
        is Estados.Idle -> {
            return nivel_actual
        }

        is Estados.MovingUP -> {
            nivel_actual = 2
            return nivel_actual
        }

        is Estados.MovingDOWN -> {
            nivel_actual = 2
            return nivel_actual
        }

        is Estados.Error -> {
            nivel_actual = -1
            return nivel_actual
        }
    }
}

fun nivel_0(): Int {
    if (estado_acual is Estados.Idle && nivel_actual == 1) {
        nivel_destino = 0
        estado_acual = Estados.MovingDOWN
    }

    return gestor()
}
