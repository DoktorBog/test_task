package com.test.presentation.extensions

import android.app.Activity
import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.annotation.DrawableRes
import android.support.annotation.StringRes
import android.support.annotation.StyleRes
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.test.presentation.R
import org.jetbrains.anko.bundleOf
import org.jetbrains.anko.contentView



inline fun <reified T : Any> Activity.launchActivity(
        requestCode: Int = -1,
        options: Bundle? = null,
        noinline init: Intent.() -> Unit = {}) {

    val intent = newIntent<T>(this)
    intent.init()
    startActivityForResult(intent, requestCode, options)
}

inline fun <reified T : Any> Context.launchActivity(
        options: Bundle? = null,
        noinline init: Intent.() -> Unit = {}) {

    val intent = newIntent<T>(this)
    intent.init()
    startActivity(intent, options)
}


inline fun <reified T : Any> newIntent(context: Context): Intent =
        Intent(context, T::class.java)

inline fun Activity.launchActivity(requestCode: Int? = null, setup: Intent.() -> Unit) {
    val intent = Intent().apply(setup)
    if (requestCode != null) startActivityForResult(intent, requestCode)
    else startActivity(intent)
}

inline fun Activity.launchActivityForAction(action: String,
                                            requestCode: Int? = null,
                                            type: String? = null,
                                            data: Uri? = null,
                                            vararg extras: Pair<String, Any>,
                                            setup: Intent.() -> Unit = {}): Boolean {
    val intent = Intent(action).apply {
        type?.let(this::setType)
        data?.let(this::setData)
        extras.takeIf { it.isNotEmpty() }?.let(::bundleOf)?.let(this::putExtras)
        setup()
    }

    if (intent.resolveActivity(packageManager) == null) return false

    if (requestCode != null) startActivityForResult(intent, requestCode)
    else startActivity(intent)

    return true
}

fun AppCompatActivity.setToolbarLeftIcon(toolbar: Toolbar, @DrawableRes int: Int) {
    val drawable = ContextCompat.getDrawable(this, int)
    toolbar.navigationIcon = drawable
    setSupportActionBar(toolbar)
    supportActionBar?.setDisplayHomeAsUpEnabled(true)
}

fun Activity.hideKeyboard() {
    currentFocus?.let {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(it.applicationWindowToken, 0)
    }
}

fun Activity.showKeyboard() {
    currentFocus?.let {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(it, InputMethodManager.SHOW_IMPLICIT)
    }
}

fun AppCompatActivity.requireSupportActionBar() = supportActionBar ?: throw IllegalStateException("SupportActionBar must be already set")

fun Activity.snackbar(message: String,
                      view: View = this.contentView!!,
                      duration: Int = Snackbar.LENGTH_SHORT,
                      additionalConfigs: (Snackbar.() -> Unit)? = null) =
        Snackbar.make(view, message, duration)
                .apply { additionalConfigs?.invoke(this) }
                .show()

fun Activity.snackbar(@StringRes
                      messageRes: Int,
                      view: View = this.contentView!!,
                      duration: Int = Snackbar.LENGTH_SHORT,
                      additionalConfigs: (Snackbar.() -> Unit)? = null) =
        Snackbar.make(view, messageRes, duration)
                .apply { additionalConfigs?.invoke(this) }
                .show()

fun Activity.longSnackbar(message: String,
                          view: View = this.contentView!!,
                          additionalConfigs: (Snackbar.() -> Unit)? = null) =
        snackbar(message, view, Snackbar.LENGTH_LONG, additionalConfigs)

fun Activity.longSnackbar(@StringRes
                          messageRes: Int,
                          view: View = this.contentView!!,
                          additionalConfigs: (Snackbar.() -> Unit)? = null) =
        snackbar(messageRes, view, Snackbar.LENGTH_LONG, additionalConfigs)

fun Activity.indefiniteSnackbar(message: String,
                                view: View = this.contentView!!,
                                additionalConfigs: (Snackbar.() -> Unit)? = null) =
        snackbar(message, view, Snackbar.LENGTH_INDEFINITE, additionalConfigs)

fun Activity.indefiniteSnackbar(@StringRes
                                messageRes: Int,
                                view: View = this.contentView!!,
                                additionalConfigs: (Snackbar.() -> Unit)? = null) =
        snackbar(messageRes, view, Snackbar.LENGTH_INDEFINITE, additionalConfigs)


@Suppress("DEPRECATION")
inline fun Activity.lazyProgressDialog(@StyleRes themeRes: Int? = null,
                                       @StringRes titleRes: Int = R.string.loading,
                                       @StringRes messageRes: Int = R.string.please_wait,
                                       isCancelable: Boolean = false): Lazy<ProgressDialog> =
        lazy { newProgressDialog(this, themeRes, titleRes, messageRes, isCancelable) }

inline fun newProgressDialog(context: Context,
                             @StyleRes themeRes: Int? = null,
                             @StringRes titleRes: Int = R.string.loading,
                             @StringRes messageRes: Int = R.string.please_wait,
                             isCancelable: Boolean = false): ProgressDialog =
        (themeRes?.let { ProgressDialog(context, it) } ?: ProgressDialog(context)).apply {
            setTitle(titleRes)
            setMessage(context.getString(messageRes))
            setCancelable(isCancelable)
        }
