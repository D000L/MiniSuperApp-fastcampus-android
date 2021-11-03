package com.doool.minisuperapp_android.financehome

import com.uber.rib.core.RibTestBasePlaceholder
import com.uber.rib.core.RouterHelper

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class FinanceHomeRouterTest : RibTestBasePlaceholder() {

  @Mock internal lateinit var component: FinanceHomeBuilder.Component
  @Mock internal lateinit var interactor: FinanceHomeInteractor
  @Mock internal lateinit var view: FinanceHomeView

  private var router: FinanceHomeRouter? = null

  @Before
  fun setup() {
    MockitoAnnotations.initMocks(this)

    router = FinanceHomeRouter(view, interactor, component)
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

