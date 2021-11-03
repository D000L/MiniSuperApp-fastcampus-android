package com.doool.minisuperapp_android.financehome.superPayDashboard

import com.uber.rib.core.ViewRouter

/**
 * Adds and removes children of {@link SuperPayDashboardBuilder.SuperPayDashboardScope}.
 *
 * TODO describe the possible child configurations of this scope.
 */
class SuperPayDashboardRouter(
  view: SuperPayDashboardView,
  interactor: SuperPayDashboardInteractor,
  component: SuperPayDashboardBuilder.Component
) : ViewRouter<SuperPayDashboardView, SuperPayDashboardInteractor>(view, interactor, component) {

}
