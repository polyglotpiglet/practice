import java.util.Random

interface Potion {
    val name: String
    fun useItem(stats: CharacterStats): CharacterStats
}

class ManaPotion(override val name: String, val mana: Int) : Potion {
    override fun useItem(stats: CharacterStats): CharacterStats = stats.copy(
                currentHealth =  stats.currentHealth,
                currentMana = stats.currentMana + mana
        )
}

class HealthPotion(override val name: String, val health: Int): Potion {
    override fun useItem(stats: CharacterStats): CharacterStats = stats.copy(
            currentHealth =  stats.currentHealth + health,
            currentMana = stats.currentMana
    )
}

data class CharacterStats(val currentHealth: Int = 100, val currentMana: Int = 100)

class Inventory(vararg potions: Potion): List<Potion> by potions.asList() {
    val random = Random()
    fun useRandomItem(characterStats: CharacterStats, random: Random = this.random): CharacterStats {
        val randomPotion = this[random.nextInt(this.size)]
        return randomPotion.useItem(characterStats)
    }
}

