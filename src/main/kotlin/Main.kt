
// NB: val format = Json { allowStructuredMapKeys = true }

fun main(args: Array<String>) {
    val bootData = AbstractVendingMachine::class.java.classLoader
        .getResource("boot.json")!!.readText()
}