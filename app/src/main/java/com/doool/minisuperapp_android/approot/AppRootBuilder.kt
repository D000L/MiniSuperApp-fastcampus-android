package com.doool.minisuperapp_android.approot

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.savedstate.findViewTreeSavedStateRegistryOwner
import com.doool.minisuperapp_android.apphome.AppHomeBuilder
import com.doool.minisuperapp_android.financehome.FinanceHomeBuilder
import com.uber.rib.core.InteractorBaseComponent
import com.uber.rib.core.ViewBuilder
import dagger.Binds
import dagger.BindsInstance
import dagger.Provides
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy.CLASS
import javax.inject.Qualifier
import javax.inject.Scope

/**
 * Builder for the {@link AppRootScope}.
 *
 * TODO describe this scope's responsibility as a whole.
 */
class AppRootBuilder(dependency: ParentComponent) :
  ViewBuilder<AppRootView, AppRootRouter, AppRootBuilder.ParentComponent>(dependency) {

  /**
   * Builds a new [AppRootRouter].
   *
   * @param parentViewGroup parent view group that this router's view will be added to.
   * @return a new [AppRootRouter].
   */
  fun build(parentViewGroup: ViewGroup): AppRootRouter {
    val view = createView(parentViewGroup)
    val interactor = AppRootInteractor()
    val component = DaggerAppRootBuilder_Component.builder()
      .parentComponent(dependency)
      .view(view)
      .interactor(interactor)
      .build()
    return component.approotRouter()
  }

  override fun inflateView(inflater: LayoutInflater, parentViewGroup: ViewGroup): AppRootView {
    // TODO: Inflate a new view using the provided inflater, or create a new view programatically using the
    // provided context from the parentViewGroup.
    return  AppRootView(parentViewGroup.context)
  }

  interface ParentComponent {
    // TODO: Define dependencies required from your parent interactor here.
  }

  @dagger.Module
  abstract class Module {

    @AppRootScope
    @Binds
    internal abstract fun presenter(view: AppRootView): AppRootInteractor.AppRootPresenter

    @dagger.Module
    companion object {

      @AppRootScope
      @Provides
      @JvmStatic
      internal fun router(
        component: Component,
        view: AppRootView,
        interactor: AppRootInteractor
      ): AppRootRouter {
        return AppRootRouter(
          view,
          interactor,
          component,
          AppHomeBuilder(component),
          FinanceHomeBuilder(component)
        )
      }
    }

    // TODO: Create provider methods for dependencies created by this Rib. These should be static.
  }

  @AppRootScope
  @dagger.Component(
    modules = arrayOf(Module::class),
    dependencies = arrayOf(
      ParentComponent::class,
    )
  )
  interface Component : InteractorBaseComponent<AppRootInteractor>, BuilderComponent, AppHomeBuilder.ParentComponent, FinanceHomeBuilder.ParentComponent {

    @dagger.Component.Builder
    interface Builder {
      @BindsInstance
      fun interactor(interactor: AppRootInteractor): Builder

      @BindsInstance
      fun view(view: AppRootView): Builder

      fun parentComponent(component: ParentComponent): Builder
      fun build(): Component
    }
  }

  interface BuilderComponent {
    fun approotRouter(): AppRootRouter
  }

  @Scope
  @Retention(CLASS)
  internal annotation class AppRootScope

  @Qualifier
  @Retention(CLASS)
  internal annotation class AppRootInternal
}
