package com.doool.minisuperapp_android.ui.financeHome

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.doool.minisuperapp_android.financeHome.addPaymentMethod.AddPaymentMethod

@Composable
fun AddPaymentMethodUI(component: AddPaymentMethod) {
  val (cardNumber, setCardNumber) = remember { mutableStateOf("") }
  val (cvc, setCvc) = remember { mutableStateOf("") }
  val (expirationText, setExpirationText) = remember { mutableStateOf("") }

  Column(
    modifier = Modifier
      .fillMaxSize()
      .background(Color(red = 0.95f, green = 0.96f, blue = 0.98f, alpha = 1f))
      .padding(horizontal = 40.dp, vertical = 26.dp)
  ) {
    CardNumberField(
      modifier = Modifier.fillMaxWidth(),
      value = cardNumber,
      onValueChange = setCardNumber
    )
    Spacer(modifier = Modifier.height(14.dp))

    Row() {
      CvcField(modifier = Modifier.weight(1f), value = cvc, onValueChange = setCvc)
      Spacer(modifier = Modifier.width(20.dp))
      ExpirationField(
        modifier = Modifier.weight(1f),
        value = expirationText,
        onValueChange = setExpirationText
      )
    }

    Spacer(modifier = Modifier.height(20.dp))
    AddPaymentMethod {
      component.didTapConfirm(
        cardNumber,
        cvc,
        expirationText
      )
    }
  }
}

@Composable
private fun TextField(
  modifier: Modifier,
  value: String,
  label: String,
  onValueChange: (String) -> Unit
) {
  OutlinedTextField(
    modifier = modifier,
    value = value,
    shape = RoundedCornerShape(8.dp),
    onValueChange = onValueChange,
    label = { Text(text = label) },
    colors = TextFieldDefaults.outlinedTextFieldColors(backgroundColor = Color.White)
  )
}

@Composable
private fun CardNumberField(
  modifier: Modifier = Modifier,
  value: String,
  onValueChange: (String) -> Unit
) {
  TextField(
    modifier = modifier,
    value = value,
    onValueChange = onValueChange,
    label = "카드 번호"
  )
}

@Composable
private fun CvcField(
  modifier: Modifier = Modifier,
  value: String,
  onValueChange: (String) -> Unit
) {
  TextField(
    modifier = modifier,
    value = value,
    onValueChange = onValueChange,
    label = "CVC"
  )
}

@Composable
private fun ExpirationField(
  modifier: Modifier = Modifier,
  value: String,
  onValueChange: (String) -> Unit
) {
  TextField(
    modifier = modifier,
    value = value,
    onValueChange = onValueChange,
    label = "유효기간"
  )
}

@Composable
private fun AddPaymentMethod(didTabConfirm: () -> Unit) {
  Box(
    Modifier
      .height(52.dp)
      .fillMaxWidth()
      .background(
        color = Color(red = 0.92f, green = 0.27f, blue = 0.35f, alpha = 1f),
        shape = RoundedCornerShape(16.dp)
      )
      .clickable(onClick = didTabConfirm)
  ) {
    Text(
      modifier = Modifier.align(Alignment.Center),
      fontSize = 18.sp,
      color = Color.White,
      text = "추가하기"
    )
  }
}