package com.doool.minisuperapp_android.financehome

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.cardview.widget.CardView

/**
 * Top level view for {@link FinanceHomeBuilder.FinanceHomeScope}.
 */
class FinanceHomeView @JvmOverloads constructor(
  context: Context,
  attrs: AttributeSet? = null,
  defStyle: Int = 0
) : LinearLayout(context, attrs, defStyle), FinanceHomeInteractor.FinanceHomePresenter {


}
