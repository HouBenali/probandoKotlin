package com.game.otherworld.models

import kotlinx.serialization.Serializable

@Serializable
class Monster() {
    val name = "Hero"
    var id = 0
    val userId = 0
    val skills = listOf('a', 'b', 'c', 'd')
    val hp = 10
    val attack = 1
    val defense = 1
    val speed = 1
    val evasion = 1
    val accuracy = 1
    val type = "?"
    val growth = listOf(1)

}