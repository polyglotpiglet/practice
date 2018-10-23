import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import java.util.*

class RpgTest {

    @Test
    fun `can use health potions`() {
        val potion = HealthPotion("Brew of Fevers", health = 20)

        val updatedStats = potion.useItem(CharacterStats(currentHealth = 1, currentMana = 1))

        assertThat(updatedStats, equalTo(CharacterStats(currentHealth = 21, currentMana = 1)))
    }

    @Test
    fun `can use mana potion potions`() {
        val potion = ManaPotion("Vial of Hidden Talents", mana = 10)

        val updatedStats = potion.useItem(CharacterStats(currentHealth = 1, currentMana = 1))

        assertThat(updatedStats, equalTo(CharacterStats(currentHealth = 1, currentMana = 11)))
    }

    @Test
    fun `can apply random potion`() {

        val inventory = Inventory(HealthPotion("Brew of Fevers", health = 20),
                ManaPotion("Vial of Hidden Talents", mana = 10),
                HealthPotion("Draught of Vitality", health = 50),
                HealthPotion("Potion of Healing", health = 10),
                HealthPotion("Tonic of Focus", health = 20))
        val useItem = inventory.useRandomItem(CharacterStats(), Random(1))

        assertThat(useItem, equalTo(CharacterStats(currentHealth = 120, currentMana = 100)))
    }
}