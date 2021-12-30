package com.doool.minisuperapp_android.ui.financeHome

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.arkivanov.decompose.extensions.compose.jetpack.subscribeAsState
import com.doool.minisuperapp_android.financeHome.cardOnFileDashboard.CardOnFileDashboard

@Composable
fun CardOnFileDashboardUI(component: CardOnFileDashboard) {
  val model by component.models.subscribeAsState()

  Column(modifier = Modifier.padding(horizontal = 20.dp)) {
    Header(component::didTabMore)
    Spacer(Modifier.height(6.dp))
    CardList(model.paymentMethods.slice(0..2))
    AddButton(component::didTabAddPaymentMethod)
  }
}

@Composable
private fun Header(onClickMore: () -> Unit) {
  Row() {
    Text(
      text = "카드 및 계좌",
      fontSize = 22.sp,
      color = Color.Black
    )
    Spacer(modifier = Modifier.weight(1f))
    Text(
      modifier = Modifier.clickable(onClick = onClickMore),
      color = Color(0f, 0.48f, 1f, 1f),
      fontSize = 18.sp,
      text = "전체보기"
    )
  }
}

@Composable
private fun CardList(paymentMethods: List<CardOnFileDashboard.PaymentMethod>) {
  paymentMethods.forEach {
    Box(
      Modifier
        .fillMaxWidth()
        .padding(vertical = 6.dp)
        .background(
          Color(android.graphics.Color.parseColor(it.color)),
          shape = RoundedCornerShape(16.dp)
        )
        .padding(horizontal = 20.dp)
        .height(52.dp),
      contentAlignment = Alignment.Center
    ) {
      Row(verticalAlignment = Alignment.CenterVertically) {
        Text(text = it.name, fontSize = 18.sp, color = Color.White)
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "**** ****" + it.digits, fontSize = 15.sp, color = Color.White)
      }
    }
  }
}

@Composable
private fun AddButton(didTabAddPaymentMethod: () -> Unit) {
  Box(
    Modifier
      .fillMaxWidth()
      .padding(vertical = 6.dp)
      .background(
        color = Color.LightGray,
        shape = RoundedCornerShape(16.dp)
      )
      .padding(horizontal = 20.dp)
      .height(52.dp),
    contentAlignment = Alignment.Center
  ) {
    Box(
      Modifier
        .fillMaxSize()
        .clickable { didTabAddPaymentMethod() }) {
      Icon(
        modifier = Modifier.align(Alignment.Center),
        imageVector = Icons.Default.Add,
        tint = Color.White,
        contentDescription = null
      )
    }
  }
}