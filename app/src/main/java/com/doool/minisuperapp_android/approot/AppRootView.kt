package com.doool.minisuperapp_android.approot

import android.content.Context
import android.util.AttributeSet
import android.view.Menu
import android.view.View
import android.widget.FrameLayout
import androidx.constraintlayout.widget.ConstraintLayout
import com.doool.minisuperapp_android.R
import com.google.android.material.bottomnavigation.BottomNavigationView

/**
 * Top level view for {@link AppRootBuilder.AppRootScope}.
 */

interface AppRootPresentableListener {
  fun changeTab(index: Int)
}

class AppRootView @JvmOverloads constructor(
  context: Context,
  attrs: AttributeSet? = null,
  defStyle: Int = 0
) : ConstraintLayout(context, attrs, defStyle), AppRootInteractor.AppRootPresenter {

  override var listener: AppRootPresentableListener? = null

  init {
    inflate(context, R.layout.rib_app_root, this)
    findViewById<BottomNavigationView>(R.id.bottom_nav).apply {
      menu.add(Menu.NONE, 0, Menu.NONE, "Home").setIcon(R.drawable.ic_launcher_background)
      menu.add(Menu.NONE, 1, Menu.NONE, "Finance").setIcon(R.drawable.ic_launcher_background)
    }.setOnItemSelectedListener {
      listener?.changeTab(it.itemId)
      true
    }
  }

  override fun addView(view: View) {
    findViewById<FrameLayout>(R.id.frame).apply {
      this.addView(view)
    }
  }

  override fun removeView(view: View) {
    findViewById<FrameLayout>(R.id.frame).apply {
      this.removeView(view)
    }
  }
}
