package com.doool.minisuperapp_android.financeHome.topup.models

import com.doool.minisuperapp_android.database.PaymentMethodEntity

data class PaymentMethod(
  val name: String,
  val digits: String,
  val color: String
)

fun PaymentMethodEntity.toPaymentMethod(): PaymentMethod {
  return PaymentMethod(name, digits, color)
}