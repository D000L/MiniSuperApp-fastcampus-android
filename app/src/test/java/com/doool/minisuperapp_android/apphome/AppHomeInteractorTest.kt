package com.doool.minisuperapp_android.apphome

import com.uber.rib.core.RibTestBasePlaceholder
import com.uber.rib.core.InteractorHelper

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class AppHomeInteractorTest : RibTestBasePlaceholder() {

  @Mock internal lateinit var presenter: AppHomeInteractor.AppHomePresenter
  @Mock internal lateinit var router: AppHomeRouter

  private var interactor: AppHomeInteractor? = null

  @Before
  fun setup() {
    MockitoAnnotations.initMocks(this)

    interactor = TestAppHomeInteractor.create(presenter)
  }

  /**
   * TODO: Delete this example and add real tests.
   */
  @Test
  fun anExampleTest_withSomeConditions_shouldPass() {
    // Use InteractorHelper to drive your interactor's lifecycle.
    InteractorHelper.attach<AppHomeInteractor.AppHomePresenter, AppHomeRouter>(interactor!!, presenter, router, null)
    InteractorHelper.detach(interactor!!)

    throw RuntimeException("Remove this test and add real tests.")
  }
}