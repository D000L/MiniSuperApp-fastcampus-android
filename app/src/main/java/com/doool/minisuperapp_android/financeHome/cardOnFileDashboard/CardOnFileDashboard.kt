package com.doool.minisuperapp_android.financeHome.cardOnFileDashboard

import com.arkivanov.decompose.value.Value
import com.doool.minisuperapp_android.financeHome.topup.models.PaymentMethod

interface CardOnFileDashboard {

  val models: Value<Model>

  fun didTabAddPaymentMethod()
  fun didTabMore()

  class Model(
    val paymentMethods: List<PaymentMethod>
  )
}