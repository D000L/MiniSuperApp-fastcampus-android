package com.doool.minisuperapp_android.financeHome.addPaymentMethod

interface AddPaymentMethod {

  fun ditTapClose()
  fun addCard()
  fun didTapConfirm(number : String, cvc: String, expiry: String)
}