package com.therealbluepandabear.pyxlmoose.customviews.pixelgridview

import android.view.MotionEvent
import com.therealbluepandabear.pyxlmoose.models.BitmapAction
import com.therealbluepandabear.pyxlmoose.models.Coordinates
import com.therealbluepandabear.pyxlmoose.utility.Flags

fun PixelGridView.extendedDispatchTouchEvent(event: MotionEvent): Boolean {
    val coordinateX = (event.x / scaleWidth).toInt()
    val coordinateY = (event.y / scaleHeight).toInt()

    if (currentBitmapAction == null) {
        currentBitmapAction = BitmapAction(mutableListOf())
    }

    when (event.actionMasked) {
        MotionEvent.ACTION_MOVE -> {
            if (!Flags.DisableActionMove) {
                if (coordinateX in 0 until canvasWidth && coordinateY in 0 until canvasHeight) {
                    caller.onPixelTapped(Coordinates(coordinateX, coordinateY))
                } else {
                    prevX = null
                    prevY = null
                }
            }
        }
        MotionEvent.ACTION_DOWN -> {
            if (coordinateX in 0 until canvasWidth && coordinateY in 0 until canvasHeight) {
                caller.onPixelTapped(Coordinates(coordinateX, coordinateY))
            } else {
                prevX = null
                prevY = null
            }
        }
        MotionEvent.ACTION_UP -> {
            caller.onActionUp()
        }
    }

    invalidate()

    return true
}