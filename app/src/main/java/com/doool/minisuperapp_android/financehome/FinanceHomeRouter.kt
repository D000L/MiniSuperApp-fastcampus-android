package com.doool.minisuperapp_android.financehome

import android.widget.LinearLayout
import androidx.core.view.updateLayoutParams
import com.doool.minisuperapp_android.financehome.superPayDashboard.SuperPayDashboardBuilder
import com.doool.minisuperapp_android.financehome.superPayDashboard.SuperPayDashboardRouter
import com.uber.rib.core.ViewRouter

/**
 * Adds and removes children of {@link FinanceHomeBuilder.FinanceHomeScope}.
 *
 * TODO describe the possible child configurations of this scope.
 */
class FinanceHomeRouter(
  view: FinanceHomeView,
  interactor: FinanceHomeInteractor,
  component: FinanceHomeBuilder.Component,
  val superPayDashboardBuilder: SuperPayDashboardBuilder
) : ViewRouter<FinanceHomeView, FinanceHomeInteractor>(view, interactor, component) {

  fun attach() {
    val route = superPayDashboardBuilder.build(view)
    attachChild(route)
    view.addView(route.view, LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT))
  }
}
