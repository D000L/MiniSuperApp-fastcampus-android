package com.doool.minisuperapp_android.ui.financeHome

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.graphics.toColorInt
import com.arkivanov.decompose.extensions.compose.jetpack.subscribeAsState
import com.doool.minisuperapp_android.financeHome.cardOnFileDashboard.CardOnFileDashboard

@Composable
fun CardOnFileDashboardUI(component: CardOnFileDashboard) {
  val model by component.models.subscribeAsState()

  Column() {
    Row() {
      Text(text = "카드 및 계좌")
      Spacer(modifier = Modifier.weight(1f))
      Text(text = "전체보기")
    }
    model.paymentMethods.forEach {
      Card(
        Modifier
          .fillMaxWidth()
          .background(Color(android.graphics.Color.parseColor(it.color)))
      ) {
        Row() {
          Text(text = it.name)
          Text(text = "****" + it.digits)
        }
      }
    }
    Card(
      Modifier
        .fillMaxWidth()
        .background(Color.Gray)
    ) {
      Box(Modifier.fillMaxSize().clickable { component.didTabAddPaymentMethod() }) {
        Icon(
          modifier = Modifier.align(Alignment.Center),
          imageVector = Icons.Default.Add,
          contentDescription = null
        )
      }
    }
  }
}