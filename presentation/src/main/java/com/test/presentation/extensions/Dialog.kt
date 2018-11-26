package com.test.presentation.extensions

import android.app.Dialog

fun Dialog.setVisible(visible: Boolean) {
    if (visible) show()
    else dismiss()
}