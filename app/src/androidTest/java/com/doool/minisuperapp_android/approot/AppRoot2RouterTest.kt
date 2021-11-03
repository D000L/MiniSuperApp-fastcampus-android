package com.doool.minisuperapp_android.approot

import com.uber.rib.core.RibTestBasePlaceholder
import com.uber.rib.core.RouterHelper

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class AppRoot2RouterTest : RibTestBasePlaceholder() {

  @Mock internal lateinit var component: AppRoot2Builder.Component
  @Mock internal lateinit var interactor: AppRoot2Interactor
  @Mock internal lateinit var view: AppRoot2View

  private var router: AppRoot2Router? = null

  @Before
  fun setup() {
    MockitoAnnotations.initMocks(this)

    router = AppRoot2Router(view, interactor, component)
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

