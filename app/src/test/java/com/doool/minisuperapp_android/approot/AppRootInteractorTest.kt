package com.doool.minisuperapp_android.approot

import com.uber.rib.core.RibTestBasePlaceholder
import com.uber.rib.core.InteractorHelper

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class AppRootInteractorTest : RibTestBasePlaceholder() {

  @Mock internal lateinit var presenter: AppRootInteractor.AppRootPresenter
  @Mock internal lateinit var router: AppRootRouter

  private var interactor: AppRootInteractor? = null

  @Before
  fun setup() {
    MockitoAnnotations.initMocks(this)

    interactor = TestAppRootInteractor.create(presenter)
  }

  /**
   * TODO: Delete this example and add real tests.
   */
  @Test
  fun anExampleTest_withSomeConditions_shouldPass() {
    // Use InteractorHelper to drive your interactor's lifecycle.
    InteractorHelper.attach<AppRootInteractor.AppRootPresenter, AppRootRouter>(interactor!!, presenter, router, null)
    InteractorHelper.detach(interactor!!)

    throw RuntimeException("Remove this test and add real tests.")
  }
}