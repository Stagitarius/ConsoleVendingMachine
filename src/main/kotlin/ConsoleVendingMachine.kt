import kotlinx.serialization.Serializable

enum class Ruble(override val value: Int): Coin<Int>{
    ONE(1),
    TWO(2),
    FIVE(5),
    TEN(10),
    FIVE_TEEN(50),
    ONE_HUNDRED(100)
}

class RubleCalculator: MoneyCalculator<Int>{
    override fun zero(): Int = 0

    override fun enough(expected: Int, actual: Int): Boolean = expected <= actual

    override fun add(m1: Int, m2: Int): Int = m1 + m2

}

class ConsoleVendingMachine(val productQuantity: MutableMap<NamedProduct, Int>):
    AbstractVendingMachine<Int, NamedProduct, Ruble>(RubleCalculator(), productQuantity) {
    override fun onDisplayProductIsOut(product: NamedProduct) {
        println("Product ${product.name} is out")
    }

    override fun onDisplayProductNotSelected() {
        println("Product is not selected")
    }

    override fun onEjectProduct(product: NamedProduct) {
        println("Take product ${product.name}")
    }

    override fun onEjectCoin(coin: Ruble) {
        println("Take your money ${coin.value}, bitch")
    }

}
