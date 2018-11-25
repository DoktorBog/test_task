package com.test.presentation.extensions

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity

val Fragment.appCompatActivity get() = requireActivity() as AppCompatActivity