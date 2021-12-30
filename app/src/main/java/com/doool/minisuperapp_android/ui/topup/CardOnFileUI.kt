package com.doool.minisuperapp_android.ui.topup

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.jetpack.subscribeAsState
import com.doool.minisuperapp_android.financeHome.topup.cardOnFile.CardOnFileComponent
import com.doool.minisuperapp_android.financeHome.topup.models.PaymentMethod

@OptIn(ExperimentalDecomposeApi::class)
@Composable
fun CardOnFileUI(component: CardOnFileComponent) {
  val model by component.models.subscribeAsState()

  LazyColumn() {
    items(model.paymentMethod) {
      PaymentMethod(Modifier.clickable { component.cardOnFileDidSelect(it) }, it)
    }
    item {
      AddPaymentMethod(Modifier.clickable(onClick = component::cardOnFileDidTapAddCard))
    }
  }
}

@Composable
private fun PaymentMethod(modifier: Modifier = Modifier, paymentMethod: PaymentMethod) {
  Column {
    Row(
      modifier
        .fillMaxWidth()
        .height(56.dp)
        .background(Color.White, RoundedCornerShape(8.dp))
        .padding(start = 20.dp, end = 22.dp),
      verticalAlignment = Alignment.CenterVertically
    ) {
      Box(
        Modifier
          .size(height = 34.dp, width = 46.dp)
          .background(
            Color(android.graphics.Color.parseColor(paymentMethod.color)),
            RoundedCornerShape(4.dp)
          )
      )
      Spacer(modifier = Modifier.width(22.dp))
      Text(
        text = paymentMethod.name + " **** " + paymentMethod.digits,
        color = Color.Black,
        fontSize = 16.sp
      )
    }
    Divider(color = Color.LightGray, thickness = 0.5.dp)
  }
}

@Composable
private fun AddPaymentMethod(modifier: Modifier = Modifier) {
  Column {
    Row(
      modifier
        .fillMaxWidth()
        .height(56.dp)
        .background(Color.White, RoundedCornerShape(8.dp))
        .padding(start = 20.dp, end = 22.dp),
      verticalAlignment = Alignment.CenterVertically
    ) {
      Box(
        Modifier
          .size(height = 34.dp, width = 46.dp)
          .border(width = 2.dp, color = Color.Blue, shape = RoundedCornerShape(4.dp)),
        contentAlignment = Alignment.Center
      ) {
        Icon(imageVector = Icons.Default.Add, contentDescription = null, tint = Color.Blue)
      }
      Spacer(modifier = Modifier.width(22.dp))
      Text(
        text = "카드 추가",
        color = Color.Black,
        fontSize = 16.sp
      )
    }
    Divider(color = Color.LightGray, thickness = 0.5.dp)
  }
}
