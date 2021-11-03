package com.doool.minisuperapp_android.financehome.superPayDashboard

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.doool.minisuperapp_android.R

/**
 * Top level view for {@link SuperPayDashboardBuilder.SuperPayDashboardScope}.
 */
class SuperPayDashboardView @JvmOverloads constructor(
  context: Context,
  attrs: AttributeSet? = null,
  defStyle: Int = 0
) : LinearLayout(context, attrs, defStyle), SuperPayDashboardInteractor.SuperPayDashboardPresenter {

  val linearLayout = LinearLayout(context).apply {
    orientation = LinearLayout.HORIZONTAL
  }

  val title = TextView(context).apply {
    text = "슈퍼페이 잔고"
    setTextColor(ContextCompat.getColor(context, R.color.black))
  }

  val button = AppCompatButton(context).apply {
    text = "충전하기"
    setTextColor(ContextCompat.getColor(context, R.color.black))
    setOnClickListener { onClickButton() }
    gravity = Gravity.END
  }

  val cardView = CardView(context).apply {
    radius = 16f
    setCardBackgroundColor(ContextCompat.getColor(context, R.color.purple_700))
  }

  val currencyTitle = TextView(context).apply {
    text = "10,000원"
    setTextColor(ContextCompat.getColor(context, R.color.black))
  }

  init {
    orientation = VERTICAL
    layoutParams = LayoutParams(
      LayoutParams.MATCH_PARENT,
      LayoutParams.WRAP_CONTENT
    )

    linearLayout.addView(title, LayoutParams(
      LayoutParams.WRAP_CONTENT,
      LayoutParams.WRAP_CONTENT
    ).apply { weight = 1f })
    linearLayout.addView(button)

    addView(
      linearLayout,
      LayoutParams(
        LayoutParams.MATCH_PARENT,
        LayoutParams.WRAP_CONTENT
      )
    )

    cardView.addView(
      currencyTitle,
      FrameLayout.LayoutParams(
        FrameLayout.LayoutParams.WRAP_CONTENT,
        FrameLayout.LayoutParams.WRAP_CONTENT,
        Gravity.CENTER
      )
    )

    addView(cardView, LayoutParams(LayoutParams.MATCH_PARENT, 500))
  }

  fun onClickButton() {

  }


  override fun updateBalance(balance: Double) {
    currencyTitle.text = balance.toString() + "원"
  }
}
