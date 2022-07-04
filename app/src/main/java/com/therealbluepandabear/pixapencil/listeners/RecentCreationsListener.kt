package com.therealbluepandabear.pixapencil.listeners

import com.therealbluepandabear.pixapencil.models.PixelArt

interface RecentCreationsListener {
    fun onCreationTapped(creationTapped: PixelArt)
    fun onCreationLongTapped(creationTapped: PixelArt)
    fun onStarredTapped(pixelArt: PixelArt)
    fun onUnstarredTapped(pixelArt: PixelArt)
}