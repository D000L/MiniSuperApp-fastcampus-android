package com.doool.minisuperapp_android.financeHome.addPaymentMethod

import com.arkivanov.decompose.ComponentContext
import com.doool.minisuperapp_android.financeHome.addPaymentMethod.AddPaymentMethod

class AddPaymentMethodComponent(
    componentContext: ComponentContext,
    private val addMethod: (number: String, cvc: String, expiry: String) -> Unit,
    private val onFinished: () -> Unit
) : AddPaymentMethod, ComponentContext by componentContext {

    override fun ditTapClose() {
        onFinished()
    }

    override fun addCard() {
        TODO("Not yet implemented")
    }

    override fun didTapConfirm(number: String, cvc: String, expiry: String) {
        addMethod(number, cvc, expiry)
    }

}