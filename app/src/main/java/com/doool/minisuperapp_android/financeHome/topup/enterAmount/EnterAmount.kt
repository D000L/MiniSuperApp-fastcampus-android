package com.doool.minisuperapp_android.financeHome.topup.enterAmount

import com.arkivanov.decompose.value.Value

interface EnterAmount {

  val models: Value<Model>

  fun enterAmountDidTapClose()
  fun enterAmountDidTapPaymentMethod()

  class Model(
    val selectedPaymentMethod: SelectedPaymentMethod
  )

  data class SelectedPaymentMethod(
    val name: String,
    val iamge: String
  )
}