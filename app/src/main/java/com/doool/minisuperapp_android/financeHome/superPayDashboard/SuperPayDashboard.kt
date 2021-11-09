package com.doool.minisuperapp_android.financeHome.superPayDashboard

import com.arkivanov.decompose.value.Value

interface SuperPayDashboard {

  val models: Value<Model>

  fun onClickTopup()

  class Model(
    val balance: Double
  )
}