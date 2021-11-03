package com.doool.minisuperapp_android.financehome.superPayDashboard

import android.util.Log
import com.uber.rib.core.Bundle
import com.uber.rib.core.Interactor
import com.uber.rib.core.RibInteractor
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import java.util.*
import javax.inject.Inject

/**
 * Coordinates Business Logic for [SuperPayDashboardScope].
 *
 * TODO describe the logic of this scope.
 */

interface SuperPayDashboardDependency {
  var balance : Observable<Double>
}

@RibInteractor
class SuperPayDashboardInteractor : Interactor<SuperPayDashboardInteractor.SuperPayDashboardPresenter, SuperPayDashboardRouter>() {

  @Inject
  lateinit var presenter: SuperPayDashboardPresenter

  @Inject
  lateinit var dependency: SuperPayDashboardDependency

  override fun didBecomeActive(savedInstanceState: Bundle?) {
    super.didBecomeActive(savedInstanceState)

    dependency?.balance?.observeOn(AndroidSchedulers.mainThread()).subscribe( {
      presenter.updateBalance(it)
    },{
      Log.d("Asdfasdf","Sdfasdf")
    })
    // TODO: Add attachment logic here (RxSubscriptions, etc.).
  }

  override fun willResignActive() {
    super.willResignActive()

    // TODO: Perform any required clean up here, or delete this method entirely if not needed.
  }

  /**
   * Presenter interface implemented by this RIB's view.
   */
  interface SuperPayDashboardPresenter {
    fun updateBalance (balance: Double)
  }
}
