package sae.escapegame.application

class AndroidPlatform : Platform {
    override val name: String = "Hello Android ${android.os.Build.VERSION.SDK_INT}!"
}

actual fun getPlatform(): Platform = AndroidPlatform()