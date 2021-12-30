package com.doool.minisuperapp_android.financeHome.cardOnFileDashboard

import com.arkivanov.decompose.value.Value

interface CardOnFileDashboard {

  val models: Value<Model>

  fun didTabAddPaymentMethod()
  fun didTabMore()

  class Model(
    val paymentMethods: List<PaymentMethod>
  )

  data class PaymentMethod(
    val name: String,
    val digits: String,
    val color: String
  )
}