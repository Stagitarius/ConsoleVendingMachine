import kotlinx.serialization.Serializable

@Serializable
data class NamedProduct(override val price: Int, val name: String) : Product<Int>