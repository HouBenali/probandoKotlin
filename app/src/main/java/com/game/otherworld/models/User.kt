package com.game.otherworld.models

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.ArraySerializer
import kotlinx.serialization.descriptors.listSerialDescriptor

@Serializable
class User : java.io.Serializable {
    var id = ""
    var nick = ""
    var coins = 1000
    var lvl = 0
    val points = ""
    val party = listOf(Monster())
    var monsters = listOf(Monster())


    fun setNick(nickValue: String): String {
        nick = nickValue
        return this.nick
    }

    @JvmName("getNick1")
    fun getNick(): String {
        return this.nick
    }

    fun setCoins(coinsValue: Int): Int {
        coins = coinsValue
        return this.coins
    }
    @JvmName("getCoins1")
    fun getCoins(): Int {
        return this.coins
    }

}