package ink.ptms.yesod

import org.bukkit.GameMode
import org.bukkit.entity.Entity
import org.bukkit.entity.Player
import taboolib.common.platform.Plugin
import taboolib.common.util.unsafeLazy
import taboolib.module.configuration.Config
import taboolib.module.configuration.ConfigNode
import taboolib.module.configuration.Configuration
import taboolib.module.configuration.createTempData

@ConfigNode(bind = "config.yml")
object Yesod : Plugin() {

    val data: Configuration by unsafeLazy {
        createTempData("data.yml")
    }

    @Config(migrate = true)
    lateinit var conf: Configuration
        private set

    @ConfigNode("void-protect")
    var voidProtect = false
        private set

    @ConfigNode("allow-craft")
    var allowCraft = false
        private set

    @ConfigNode("allow-craft-display")
    var allowCraftDisplay = false
        private set

    @ConfigNode("block-inventory")
    var blockInventory: List<String> = emptyList()
        private set

    @ConfigNode("block-interact")
    var blockInteract: List<String> = emptyList()
        private set

    @ConfigNode("thorn-override")
    var thornOverride = false
        private set

    @ConfigNode("block-features")
    var blockFeatures: List<String> = emptyList()
        private set

    @ConfigNode("block-teleport")
    var blockTeleport: List<String> = emptyList()
        private set

    fun Entity.bypass(hard: Boolean = false): Boolean {
        return this !is Player || isOp && gameMode == GameMode.CREATIVE && (!hard || isSneaking)
    }
}
