package com.doool.minisuperapp_android.approot

import com.uber.rib.core.RibTestBasePlaceholder
import com.uber.rib.core.RouterHelper

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class AppRootRouterTest : RibTestBasePlaceholder() {

  @Mock internal lateinit var component: AppRootBuilder.Component
  @Mock internal lateinit var interactor: AppRootInteractor
  @Mock internal lateinit var view: AppRootView

  private var router: AppRootRouter? = null

  @Before
  fun setup() {
    MockitoAnnotations.initMocks(this)

    router = AppRootRouter(
      view,
      interactor,
      AppHomeBuilder(component),
      FinanceHomeBuilder(component)
    )
  }

  /**
   * TODO: Delete this example and add real tests.
   */
  @Test
  fun anExampleTest_withSomeConditions_shouldPass() {
    // Use RouterHelper to drive your router's lifecycle.
    RouterHelper.attach(router!!)
    RouterHelper.detach(router!!)

    throw RuntimeException("Remove this test and add real tests.")
  }

}

