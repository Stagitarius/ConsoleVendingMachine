import kotlinx.serialization.json.Json

// NB: val format = Json { allowStructuredMapKeys = true }

private val json = Json { allowStructuredMapKeys = true }

fun main(args: Array<String>) {
    val bootData = AbstractVendingMachine::class.java.classLoader
        .getResource("boot.json")!!.readText()
    val productsMap = json.decodeFromString<MutableMap<NamedProduct, Int>>(bootData)
    val vendingMachine = ConsoleVendingMachine(productsMap)

    while (true) {
        println("Готов принимать команды")
        val (operation, param) = readln().split(' ', limit = 2)
        when (operation) {
            "i" -> vendingMachine.insertCoin(Ruble.entries.first { it.value == param.toInt() })
            "s" -> vendingMachine.selectProduct(productsMap.keys.first { it.name == param })
        }
        vendingMachine.disableIfEmpty()
    }
}

fun ConsoleVendingMachine.disableIfEmpty() {
    if(productQuantity.values.all { it == 0 }) System.exit(123)
}