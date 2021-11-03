package com.doool.minisuperapp_android.apphome

import com.uber.rib.core.RibTestBasePlaceholder
import com.uber.rib.core.RouterHelper

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class AppHomeRouterTest : RibTestBasePlaceholder() {

  @Mock internal lateinit var component: AppHomeBuilder.Component
  @Mock internal lateinit var interactor: AppHomeInteractor
  @Mock internal lateinit var view: AppHomeView

  private var router: AppHomeRouter? = null

  @Before
  fun setup() {
    MockitoAnnotations.initMocks(this)

    router = AppHomeRouter(view, interactor, component)
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

