package com.doool.minisuperapp_android.financeHome.topup.cardOnFile

import com.arkivanov.decompose.value.Value
import com.doool.minisuperapp_android.financeHome.topup.models.PaymentMethod

interface CardOnFile {

  val models: Value<Model>

  fun cardOnFileDidTapAddCard()
  fun cardOnFileDidSelect(paymentMethod: PaymentMethod)
  fun cardOnFileDidTapClose()

  class Model(
    val paymentMethod: List<PaymentMethod>
  )
}