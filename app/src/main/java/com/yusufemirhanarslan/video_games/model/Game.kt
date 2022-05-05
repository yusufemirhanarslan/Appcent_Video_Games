package com.yusufemirhanarslan.video_games.model

data class Game(
    val count: Int?,
    val next: String?,
    val previous: Any?,
    val results: List<Result>?,
    val user_platforms: Boolean?
)