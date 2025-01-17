package com.doool.minisuperapp_android.financeHome.topup.enterAmount

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.operator.map
import com.doool.minisuperapp_android.database.CardOnFileRepository
import com.doool.minisuperapp_android.financeHome.topup.models.PaymentMethod

class EnterAmountComponent(
  componentContext: ComponentContext,
  private val repository: CardOnFileRepository,
  private val selectedPaymentMethod: MutableValue<PaymentMethod>,
  private val showCardOnFile: () -> Unit
) : EnterAmount, ComponentContext by componentContext {

  override val models: Value<EnterAmount.Model> = selectedPaymentMethod.map {
    EnterAmount.Model(EnterAmount.SelectedPaymentMethod(it.name + " **** " + it.digits, it.color))
  }

  override fun enterAmountDidTapClose() {
    TODO("Not yet implemented")
  }

  override fun enterAmountDidTapPaymentMethod() {
    showCardOnFile()
  }

}