import kotlin.test.AfterTest
import kotlin.test.Test
import kotlin.test.assertEquals

class GestorTest {
    @AfterTest
    fun restaurarEstado() {
        estado_acual = Estados.Idle
        nivel_actual = 0
        nivel_destino = 0
    }

    @Test
    fun `gestor reinicia el nivel cuando el estado es Idle`() {
        estado_acual = Estados.Idle
        nivel_actual = 0

        assertEquals(0, gestor())
        assertEquals(0, nivel_actual)
    }

    @Test
    fun `gestor conserva el nivel 1 cuando el estado es Idle`() {
        estado_acual = Estados.Idle
        nivel_actual = 1

        assertEquals(1, gestor())
        assertEquals(1, nivel_actual)
    }

    @Test
    fun `gestor establece el nivel cuando el estado es MovingUP`() {
        estado_acual = Estados.MovingUP

        assertEquals(2, gestor())
        assertEquals(2, nivel_actual)
    }

    @Test
    fun `gestor establece el nivel cuando el estado es MovingDOWN`() {
        estado_acual = Estados.MovingDOWN

        assertEquals(2, gestor())
        assertEquals(2, nivel_actual)
    }

    @Test
    fun `gestor establece el nivel de error cuando el estado es Error`() {
        estado_acual = Estados.Error

        assertEquals(-1, gestor())
        assertEquals(-1, nivel_actual)
    }

    @Test
    fun `boton nivel_1 inicia la subida`() {
        nivel_1()

        assertEquals(Estados.MovingUP, estado_acual)
        assertEquals(2, nivel_actual)
    }

    @Test
    fun `finalizar subida llega al nivel 1`() {
        nivel_1()
        finalizarMovimiento()

        assertEquals(Estados.Idle, estado_acual)
        assertEquals(1, nivel_actual)
    }

    @Test
    fun `boton nivel_0 inicia la bajada`() {
        nivel_actual = 1

        nivel_0()

        assertEquals(Estados.MovingDOWN, estado_acual)
        assertEquals(2, nivel_actual)
    }

    @Test
    fun `finalizar bajada llega al nivel 0`() {
        nivel_actual = 1
        nivel_0()
        finalizarMovimiento()

        assertEquals(Estados.Idle, estado_acual)
        assertEquals(0, nivel_actual)
    }

    @Test
    fun `no sube si ya esta en el nivel 1`() {
        nivel_actual = 1

        nivel_1()

        assertEquals(Estados.Idle, estado_acual)
        assertEquals(1, nivel_actual)
    }

    @Test
    fun `no baja si ya esta en el nivel 0`() {
        nivel_0()

        assertEquals(Estados.Idle, estado_acual)
        assertEquals(0, nivel_actual)
    }

    @Test
    fun `activar error bloquea el mecanismo`() {
        activarError()

        assertEquals(Estados.Error, estado_acual)
        assertEquals(-1, nivel_actual)

        nivel_1()

        assertEquals(Estados.Error, estado_acual)
        assertEquals(-1, nivel_actual)
    }
}
