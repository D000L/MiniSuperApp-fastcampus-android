package com.doool.minisuperapp_android.financeHome

import com.arkivanov.decompose.ComponentContext
import com.doool.minisuperapp_android.database.DefaultFinanceDatabase
import com.doool.minisuperapp_android.financeHome.addPaymentMethod.AddPaymentMethod
import com.doool.minisuperapp_android.financeHome.addPaymentMethod.AddPaymentMethodComponent
import com.doool.minisuperapp_android.financeHome.cardOnFileDashboard.CardOnFileDashboard
import com.doool.minisuperapp_android.financeHome.cardOnFileDashboard.CardOnFileDashboardComponent
import com.doool.minisuperapp_android.financeHome.superPayDashboard.SuperPayDashboard
import com.doool.minisuperapp_android.financeHome.superPayDashboard.SuperPayDashboardComponent

class FinanceHomeComponent(
  componentContext: ComponentContext
) : FinanceHome, ComponentContext by componentContext {

  private val database = DefaultFinanceDatabase()

  override val superPayDashboard: SuperPayDashboard = SuperPayDashboardComponent(this, database, {})
  override val cardOnFileDashboard: CardOnFileDashboard =
    CardOnFileDashboardComponent(this, database, {})


  override val addPaymentMethod: AddPaymentMethod =
    AddPaymentMethodComponent(this, { number: String, cvc: String, expiry: String ->

    }, {

    })


}