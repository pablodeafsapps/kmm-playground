package org.deafsapps.kmm.kmmplayground

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform