
import vm.*
import vm.Product as VmProduct

class Rubles(val amount: Int)

enum class RubleCoins(override val value: Rubles) : Coin<Rubles> {
    FIVE(Rubles(5)), TEN(Rubles(10))
}

class Product(
    override var availableCount: Int,
    override val price: Rubles,
    val name: String,
) : VmProduct<Rubles>

data class BootState(val products: List<Product>)

class ConsoleVendingMachine(private val bootState: BootState) {


    fun runInfinite(): Nothing {
        TODO()
    }
}