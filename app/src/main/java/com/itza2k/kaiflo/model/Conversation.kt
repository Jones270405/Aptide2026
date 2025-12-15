package com.itza2k.kaiflo.model
import com.itza2k.kaiflo.util.Category
import java.net.URI

data class Conversation(
    var id: Long = System.currentTimeMillis() * 1_000_000 + (System.nanoTime() % 1_000_000),
    var englishText: String,
    var translatedText: String,
    val isMe: Boolean,
    val isLoading: Boolean = false,
    var category: String = Category.OTHER.name,
    val contentURL: String = "",
    val navigationURI: URI = URI(""),
    // timestamp for date separators and ordering
    val createdAt: Long = System.currentTimeMillis()
)