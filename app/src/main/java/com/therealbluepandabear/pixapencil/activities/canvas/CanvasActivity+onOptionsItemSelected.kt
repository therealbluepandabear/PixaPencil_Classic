package com.therealbluepandabear.pixapencil.activities.canvas

import android.graphics.Bitmap
import android.view.MenuItem
import com.therealbluepandabear.pixapencil.R
import com.therealbluepandabear.pixapencil.extensions.hideItems
import com.therealbluepandabear.pixapencil.extensions.navigateTo
import com.therealbluepandabear.pixapencil.extensions.showDialog
import com.therealbluepandabear.pixapencil.fragments.canvas.pixelGridViewInstance
import com.therealbluepandabear.pixapencil.fragments.newcolorpalette.NewColorPaletteFragment
import com.therealbluepandabear.pixapencil.utility.IntConstants
import com.therealbluepandabear.pixapencil.utility.StringConstants

const val zoomIncrement = 0.2f

fun CanvasActivity.extendedOnOptionsItemSelected(item: MenuItem): Boolean {

    when (item.itemId) {
        R.id.activityCanvasTopAppMenu_zoom_out_item -> {
            zoomOut()
        }

        R.id.activityCanvasTopAppMenu_zoom_in_item -> {
            zoomIn()
        }

        R.id.activityMainTopAppMenu_community_item -> {
            extendedSaveProject()
        }

        R.id.activityCanvasTopAppMenu_undo -> {
            extendedUndo()
        }

        R.id.activityCanvasTopAppMenu_redo_item -> {
            extendedRedo()
        }

        R.id.activityCanvasTopAppMenu_new_color_palette_item -> {
            newColorPaletteFragmentInstance = NewColorPaletteFragment.newInstance()
            currentFragmentInstance = newColorPaletteFragmentInstance
            navigateTo(supportFragmentManager, newColorPaletteFragmentInstance, R.id.activityCanvas_primaryFragmentHost, getString(R.string.fragment_new_color_palette_title_in_code_str), binding.activityCanvasPrimaryFragmentHost, binding.activityCanvasRootLayout)
            menu.hideItems()
        }

        R.id.activityCanvasTopAppMenu_pixel_perfect_item -> {
            pixelGridViewInstance.pixelPerfectMode = !pixelGridViewInstance.pixelPerfectMode

            menu.findItem(R.id.activityCanvasTopAppMenu_pixel_perfect_item).isChecked = pixelGridViewInstance.pixelPerfectMode

            with (sharedPreferenceObject.edit()) {
                putBoolean(StringConstants.SharedPreferencePixelPerfectIdentifier, pixelGridViewInstance.pixelPerfectMode)
                apply()
            }
        }

        R.id.activityCanvasTopAppMenu_export_to_png_item -> {
            pixelGridViewInstance.saveAsImage(Bitmap.CompressFormat.PNG)
        }

        R.id.activityCanvasTopAppMenu_export_to_jpg_item -> {
            pixelGridViewInstance.saveAsImage(Bitmap.CompressFormat.JPEG)
        }

        R.id.appMenu_rotate_90_degrees_clockwise_subItem -> {
            outerCanvasInstance.rotate()
        }

        R.id.appMenu_rotate_180_degrees_clockwise_subItem -> {
            outerCanvasInstance.rotate(IntConstants.DegreesOneEighty)
        }

        R.id.appMenu_rotate_90_degrees_anti_clockwise_subItem -> {
            outerCanvasInstance.rotate(IntConstants.DegreesNinety, animate = true, clockwise = false)
        }

        R.id.activityCanvasTopAppMenu_reset_zoom_subItem -> {
            resetZoom()
        }

        R.id.activityCanvasTopAppMenu_clear_canvas_item -> {
            showDialog(
                getString(R.string.dialog_clear_canvas_title_in_code_str),
                getString(R.string.dialog_clear_canvas_message_in_code_str),
                getString(R.string.dialog_positive_button_text_in_code_str),
                { _, _ ->
                    clearCanvas()
                }, getString(R.string.dialog_negative_button_text_in_code_str), { _, _ -> }, null)
        }

        R.id.activityCanvasTopAppMenu_find_and_replace_item -> {
            findAndReplaceToolOnToolTapped()
        }

        R.id.activityCanvasTopAppMenu_grid_item -> {
            pixelGridViewInstance.gridEnabled = !pixelGridViewInstance.gridEnabled

            menu.findItem(R.id.activityCanvasTopAppMenu_grid_item).isChecked = pixelGridViewInstance.gridEnabled

            with (sharedPreferenceObject.edit()) {
                putBoolean(StringConstants.SharedPreferenceGridIdentifier, pixelGridViewInstance.gridEnabled)
                apply()
            }

            pixelGridViewInstance.invalidate()
        }
    }
    return true
}