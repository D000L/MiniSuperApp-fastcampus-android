package com.doool.minisuperapp_android.financehome

import android.view.LayoutInflater
import android.view.ViewGroup
import com.doool.minisuperapp_android.financehome.superPayDashboard.SuperPayDashboardBuilder
import com.doool.minisuperapp_android.financehome.superPayDashboard.SuperPayDashboardDependency
import com.uber.rib.core.InteractorBaseComponent
import com.uber.rib.core.ViewBuilder
import dagger.Binds
import dagger.BindsInstance
import dagger.Provides
import io.reactivex.Observable
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy.CLASS
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Qualifier
import javax.inject.Scope

/**
 * Builder for the {@link FinanceHomeScope}.
 *
 * TODO describe this scope's responsibility as a whole.
 */
class FinanceHomeBuilder(dependency: ParentComponent) :
  ViewBuilder<FinanceHomeView, FinanceHomeRouter, FinanceHomeBuilder.ParentComponent>(dependency) {

  /**
   * Builds a new [FinanceHomeRouter].
   *
   * @param parentViewGroup parent view group that this router's view will be added to.
   * @return a new [FinanceHomeRouter].
   */
  fun build(parentViewGroup: ViewGroup): FinanceHomeRouter {
    val view = createView(parentViewGroup)
    val interactor = FinanceHomeInteractor()

    val component = DaggerFinanceHomeBuilder_Component.builder()
      .parentComponent(dependency)
      .dependency(object : SuperPayDashboardDependency{
        override var balance: Observable<Double> = Observable
          .just(1.0).delay(2, TimeUnit.SECONDS)
      })
      .view(view)
      .interactor(interactor)
      .build()
    return component.financehomeRouter()
  }

  override fun inflateView(inflater: LayoutInflater, parentViewGroup: ViewGroup): FinanceHomeView {
    // TODO: Inflate a new view using the provided inflater, or create a new view programatically using the
    // provided context from the parentViewGroup.
    return FinanceHomeView(parentViewGroup.context)
  }

  interface ParentComponent {
    // TODO: Define dependencies required from your parent interactor here.
  }

  @dagger.Module
  abstract class Module {

    @FinanceHomeScope
    @Binds
    internal abstract fun presenter(view: FinanceHomeView): FinanceHomeInteractor.FinanceHomePresenter

    @dagger.Module
    companion object {

      @FinanceHomeScope
      @Provides
      @JvmStatic
      internal fun router(
        component: Component,
        view: FinanceHomeView,
        interactor: FinanceHomeInteractor,
      ): FinanceHomeRouter {
        return FinanceHomeRouter(view,
          interactor,
          component,
          SuperPayDashboardBuilder(component))
      }
    }

    // TODO: Create provider methods for dependencies created by this Rib. These should be static.
  }

  @FinanceHomeScope
  @dagger.Component(
    modules = arrayOf(Module::class),
    dependencies = arrayOf(ParentComponent::class)
  )
  interface Component : InteractorBaseComponent<FinanceHomeInteractor>, BuilderComponent,
    SuperPayDashboardBuilder.ParentComponent {

    @dagger.Component.Builder
    interface Builder {
      @BindsInstance
      fun interactor(interactor: FinanceHomeInteractor): Builder

      @BindsInstance
      fun dependency(dependency: SuperPayDashboardDependency): Builder

      @BindsInstance
      fun view(view: FinanceHomeView): Builder

      fun parentComponent(component: ParentComponent): Builder
      fun build(): Component
    }
  }

  interface BuilderComponent {
    fun financehomeRouter(): FinanceHomeRouter
  }

  @Scope
  @Retention(CLASS)
  internal annotation class FinanceHomeScope

  @Qualifier
  @Retention(CLASS)
  internal annotation class FinanceHomeInternal
}
