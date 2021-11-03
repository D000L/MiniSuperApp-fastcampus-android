package com.doool.minisuperapp_android.approot

import com.doool.minisuperapp_android.apphome.AppHomeBuilder
import com.doool.minisuperapp_android.apphome.AppHomeRouter
import com.doool.minisuperapp_android.financehome.FinanceHomeBuilder
import com.doool.minisuperapp_android.financehome.FinanceHomeRouter
import com.uber.rib.core.BasicViewRouter
import com.uber.rib.core.ViewRouter

/**
 * Adds and removes children of {@link AppRootBuilder.AppRootScope}.
 *
 * TODO describe the possible child configurations of this scope.
 */
class  AppRootRouter(
  view: AppRootView,
  interactor: AppRootInteractor,
  component: AppRootBuilder.Component,
  val appHomeBuilder: AppHomeBuilder,
  val financeHomeBuilder: FinanceHomeBuilder
) : ViewRouter<AppRootView, AppRootInteractor>(view, interactor,component) {

  var appHomeRouting: AppHomeRouter? = null
  var financeHomeRouting: FinanceHomeRouter? = null

  fun attachHome() {
    detachHome()
    val route = appHomeBuilder.build(view)
    attachChild(route)
    appHomeRouting = route
    view.addView(route.view)
  }

  fun detachHome() {
    appHomeRouting?.let {
      detachChild(it)
      view.removeView(it.view)
    }
    appHomeRouting= null
  }

  fun attachFinanceHome() {
    detachFinanceHome()
    val route = financeHomeBuilder.build(view)
    attachChild(route)
    financeHomeRouting = route
    view.addView(route.view)
  }

  fun detachFinanceHome() {
    financeHomeRouting?.let {
      detachChild(it)
      view.removeView(it.view)
    }
    financeHomeRouting= null
  }
}
