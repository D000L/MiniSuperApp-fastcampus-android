package com.doool.minisuperapp_android.financehome.superPayDashboard

import com.uber.rib.core.RibTestBasePlaceholder
import com.uber.rib.core.InteractorHelper

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class SuperPayDashboardInteractorTest : RibTestBasePlaceholder() {

  @Mock internal lateinit var presenter: SuperPayDashboardInteractor.SuperPayDashboardPresenter
  @Mock internal lateinit var router: SuperPayDashboardRouter

  private var interactor: SuperPayDashboardInteractor? = null

  @Before
  fun setup() {
    MockitoAnnotations.initMocks(this)

    interactor = TestSuperPayDashboardInteractor.create(presenter)
  }

  /**
   * TODO: Delete this example and add real tests.
   */
  @Test
  fun anExampleTest_withSomeConditions_shouldPass() {
    // Use InteractorHelper to drive your interactor's lifecycle.
    InteractorHelper.attach<SuperPayDashboardInteractor.SuperPayDashboardPresenter, SuperPayDashboardRouter>(interactor!!, presenter, router, null)
    InteractorHelper.detach(interactor!!)

    throw RuntimeException("Remove this test and add real tests.")
  }
}