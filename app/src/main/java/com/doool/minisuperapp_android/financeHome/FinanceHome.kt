package com.doool.minisuperapp_android.financeHome

import com.doool.minisuperapp_android.financeHome.addPaymentMethod.AddPaymentMethod
import com.doool.minisuperapp_android.financeHome.cardOnFileDashboard.CardOnFileDashboard
import com.doool.minisuperapp_android.financeHome.superPayDashboard.SuperPayDashboard

interface FinanceHome {

  val addPaymentMethod: AddPaymentMethod
  val cardOnFileDashboard: CardOnFileDashboard
  val superPayDashboard: SuperPayDashboard

}