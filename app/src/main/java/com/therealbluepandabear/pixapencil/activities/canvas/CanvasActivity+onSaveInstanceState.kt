package com.therealbluepandabear.pixapencil.activities.canvas

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import com.therealbluepandabear.pixapencil.converters.BitmapConverter
import com.therealbluepandabear.pixapencil.fragments.canvas.pixelGridViewInstance
import com.therealbluepandabear.pixapencil.utility.StringConstants

fun CanvasActivity.extendedOnSaveInstanceState(outState: Bundle) {
    outState.putInt(StringConstants.prevOrientationBundleIdentifier, resources.configuration.orientation)
    outState.putString(StringConstants.prevBitmapStrBundleIdentifier, BitmapConverter.convertBitmapToString(pixelGridViewInstance.pixelGridViewBitmap))
    outState.putInt(StringConstants.prevPrimaryColorBundleIdentifier, (binding.activityCanvasColorPrimaryView.background as ColorDrawable).color)
    outState.putInt(StringConstants.prevSecondaryColorBundleIdentifier, (binding.activityCanvasColorSecondaryView.background as ColorDrawable).color)
}