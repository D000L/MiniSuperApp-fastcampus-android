package com.doool.minisuperapp_android

import android.view.ViewGroup
import com.doool.minisuperapp_android.apphome.AppHomeBuilder
import com.doool.minisuperapp_android.approot.AppRootBuilder
import com.doool.minisuperapp_android.financehome.FinanceHomeBuilder
import com.uber.rib.core.RibActivity
import com.uber.rib.core.ViewRouter

class MainActivity : RibActivity() {
  override fun createRouter(parentViewGroup: ViewGroup): ViewRouter<*, *> {
    return AppRootBuilder(AppComponent()).build(parentViewGroup)
  }
}

class AppComponent : AppRootBuilder.ParentComponent, AppHomeBuilder.ParentComponent, FinanceHomeBuilder.ParentComponent