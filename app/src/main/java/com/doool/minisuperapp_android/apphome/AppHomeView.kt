package com.doool.minisuperapp_android.apphome

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import com.doool.minisuperapp_android.R

/**
 * Top level view for {@link AppHomeBuilder.AppHomeScope}.
 */
class AppHomeView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0) : LinearLayout(context, attrs, defStyle), AppHomeInteractor.AppHomePresenter {

  init {
    setBackgroundColor(ContextCompat.getColor(context, R.color.black))
  }
}
