package com.doool.minisuperapp_android.apphome

import android.view.View

import com.uber.rib.core.ViewRouter

/**
 * Adds and removes children of {@link AppHomeBuilder.AppHomeScope}.
 *
 * TODO describe the possible child configurations of this scope.
 */
class AppHomeRouter(
    view: AppHomeView,
    interactor: AppHomeInteractor,
    component: AppHomeBuilder.Component) : ViewRouter<AppHomeView, AppHomeInteractor>(view, interactor, component)
