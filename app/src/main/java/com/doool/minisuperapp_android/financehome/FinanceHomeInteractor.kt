package com.doool.minisuperapp_android.financehome

import com.uber.rib.core.Bundle
import com.uber.rib.core.Interactor
import com.uber.rib.core.RibInteractor
import javax.inject.Inject

/**
 * Coordinates Business Logic for [FinanceHomeScope].
 *
 * TODO describe the logic of this scope.
 */
@RibInteractor
class FinanceHomeInteractor : Interactor<FinanceHomeInteractor.FinanceHomePresenter, FinanceHomeRouter>() {

  @Inject
  lateinit var presenter: FinanceHomePresenter

  override fun didBecomeActive(savedInstanceState: Bundle?) {
    super.didBecomeActive(savedInstanceState)

    router.attach()
    // TODO: Add attachment logic here (RxSubscriptions, etc.).
  }

  override fun willResignActive() {
    super.willResignActive()

    // TODO: Perform any required clean up here, or delete this method entirely if not needed.
  }

  /**
   * Presenter interface implemented by this RIB's view.
   */
  interface FinanceHomePresenter {

  }
}
