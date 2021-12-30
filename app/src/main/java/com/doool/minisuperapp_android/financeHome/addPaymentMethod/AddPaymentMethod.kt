package com.doool.minisuperapp_android.financeHome.addPaymentMethod

interface AddPaymentMethod {

  fun ditTapClose()
  fun didTapConfirm(number : String, cvc: String, expiry: String)
}