package com.doool.minisuperapp_android.approot

import androidx.annotation.CallSuper
import com.uber.rib.core.Bundle
import com.uber.rib.core.Interactor
import com.uber.rib.core.RibInteractor
import javax.inject.Inject

/**
 * Coordinates Business Logic for [AppRootScope].
 *
 * TODO describe the logic of this scope.
 */
@RibInteractor
class AppRootInteractor : Interactor<AppRootInteractor.AppRootPresenter, AppRootRouter>(), AppRootPresentableListener{

  @Inject
  lateinit var presenter: AppRootPresenter

  override fun didBecomeActive(savedInstanceState: Bundle?) {
    super.didBecomeActive(savedInstanceState)

    presenter.listener = this
    router.attachHome()
//     TODO: Add attachment logic here (RxSubscriptions, etc.).
  }

  override fun willResignActive() {
    super.willResignActive()

    // TODO: Perform any required clean up here, or delete this method entirely if not needed.
  }

  /**
   * Presenter interface implemented by this RIB's view.
   */
  interface AppRootPresenter {
    var listener: AppRootPresentableListener?
  }

  override fun changeTab(index: Int) {
    if(index == 0){
      router.detachFinanceHome()
      router.attachHome()
    }else{
      router.detachHome()
      router.attachFinanceHome()
    }
  }
}
