package ink.ptms.yesod.command

import ink.ptms.yesod.Yesod
import org.bukkit.entity.Player
import taboolib.common.platform.command.CommandBody
import taboolib.common.platform.command.CommandHeader
import taboolib.common.platform.command.mainCommand
import taboolib.module.configuration.util.setLocation
import taboolib.platform.util.toProxyLocation

@CommandHeader(name = "setserverspawn", permission = "admin")
object CommandSetSpawn {

    @CommandBody
    val main = mainCommand {
        execute<Player> { sender, _, _ ->
            val loc = sender.location.clone()
            Yesod.data.setLocation("spawn", loc.toProxyLocation())
            sender.sendMessage("服务器出生点已被重设在${loc.x},${loc.y},${loc.z}(${loc.yaw},${loc.pitch})")
        }
    }
}
