package com.doool.minisuperapp_android.financehome

import com.uber.rib.core.RibTestBasePlaceholder
import com.uber.rib.core.InteractorHelper

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class FinanceHomeInteractorTest : RibTestBasePlaceholder() {

  @Mock internal lateinit var presenter: FinanceHomeInteractor.FinanceHomePresenter
  @Mock internal lateinit var router: FinanceHomeRouter

  private var interactor: FinanceHomeInteractor? = null

  @Before
  fun setup() {
    MockitoAnnotations.initMocks(this)

    interactor = TestFinanceHomeInteractor.create(presenter)
  }

  /**
   * TODO: Delete this example and add real tests.
   */
  @Test
  fun anExampleTest_withSomeConditions_shouldPass() {
    // Use InteractorHelper to drive your interactor's lifecycle.
    InteractorHelper.attach<FinanceHomeInteractor.FinanceHomePresenter, FinanceHomeRouter>(interactor!!, presenter, router, null)
    InteractorHelper.detach(interactor!!)

    throw RuntimeException("Remove this test and add real tests.")
  }
}