package com.doool.minisuperapp_android.ui.financeHome

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.doool.minisuperapp_android.financeHome.FinanceHome

@Composable
fun FinanceHomeUI(component: FinanceHome) {
  Column(Modifier.verticalScroll(rememberScrollState())) {
    SuperPayDashboardUI(component = component.superPayDashboard)
    CardOnFileDashboardUI(component = component.cardOnFileDashboard)
  }
}
