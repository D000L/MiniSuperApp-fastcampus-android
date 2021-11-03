package com.doool.minisuperapp_android.approot

import com.uber.rib.core.RibTestBasePlaceholder
import com.uber.rib.core.InteractorHelper

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class AppRoot2InteractorTest : RibTestBasePlaceholder() {

  @Mock internal lateinit var presenter: AppRoot2Interactor.AppRoot2Presenter
  @Mock internal lateinit var router: AppRoot2Router

  private var interactor: AppRoot2Interactor? = null

  @Before
  fun setup() {
    MockitoAnnotations.initMocks(this)

    interactor = TestAppRoot2Interactor.create(presenter)
  }

  /**
   * TODO: Delete this example and add real tests.
   */
  @Test
  fun anExampleTest_withSomeConditions_shouldPass() {
    // Use InteractorHelper to drive your interactor's lifecycle.
    InteractorHelper.attach<AppRoot2Interactor.AppRoot2Presenter, AppRoot2Router>(interactor!!, presenter, router, null)
    InteractorHelper.detach(interactor!!)

    throw RuntimeException("Remove this test and add real tests.")
  }
}