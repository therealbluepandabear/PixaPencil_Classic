package com.therealbluepandabear.pixapencil.activities.canvas

import com.therealbluepandabear.pixapencil.fragments.canvas.pixelGridViewInstance
import com.therealbluepandabear.pixapencil.utility.Flags
import com.therealbluepandabear.pixapencil.utility.StringConstants

fun applyGridEnabledValueFromPreference() {
    if (sharedPreferenceObject.contains(StringConstants.Identifiers.SharedPreferenceGridIdentifier) && !Flags.DisableGridSharedPreferenceChanges) {
        pixelGridViewInstance.gridEnabled = sharedPreferenceObject.getBoolean(StringConstants.Identifiers.SharedPreferenceGridIdentifier, false)
    }
}