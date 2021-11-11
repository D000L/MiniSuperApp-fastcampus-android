package com.doool.minisuperapp_android.ui.financeHome

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.doool.minisuperapp_android.financeHome.addPaymentMethod.AddPaymentMethod

@Composable
fun AddPaymentMethodUI(component: AddPaymentMethod) {
  Text(text = "카드 추가")

  val (cardNumber, setCardNumber) = remember { mutableStateOf("") }
  val (cvc, setCvc) = remember { mutableStateOf("") }
  val (expirationText, setExpirationText) = remember { mutableStateOf("") }

  Column {
    CardNumberField(value = cardNumber, onValueChange = setCardNumber)
    Row {
      CvcField(value = cvc, onValueChange = setCvc)
      ExpirationTextField(value = expirationText, onValueChange = setExpirationText)
    }
    Box(Modifier.clickable {
      component.didTapConfirm(
        cardNumber,
        cvc,
        expirationText
      )
    }) {
      Text(modifier = Modifier.align(Alignment.Center), text = "카드 추가")
    }
  }
}

@Composable
private fun CardNumberField(value: String, onValueChange: (String) -> Unit) {
  TextField(value = value, onValueChange = onValueChange)
}

@Composable
private fun CvcField(value: String, onValueChange: (String) -> Unit) {
  TextField(value = value, onValueChange = onValueChange)
}

@Composable
private fun ExpirationTextField(value: String, onValueChange: (String) -> Unit) {
  TextField(value = value, onValueChange = onValueChange)
}