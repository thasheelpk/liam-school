package com.ahmedtikiwa.liam.bindings

import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout

@BindingAdapter("app:errorText")
fun setErrorMessage(view : TextInputLayout, error : String) {
    view.error = error
}