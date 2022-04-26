package com.envoy.coffeeshop.base

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.viewbinding.ViewBinding
import com.envoy.coffeeshop.ext.observe

abstract class BaseActivity<VB : ViewDataBinding, VM : BaseViewModel>: AppCompatActivity() {
    private lateinit var viewModel: VM
    private lateinit var binding: VB

    @get:LayoutRes
    abstract val layoutId: Int

    abstract fun getVM(): VM

    abstract fun bindVM(binding: VB, vm: VM)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutId)
        viewModel = getVM()
        bindVM(binding, viewModel)
        with(viewModel) {
            observe(progressLiveEvent) { show ->
                if (show) showProgress()
                else hideProgress()
            }

            observe(errorMessage) { msg ->
                Toast.makeText(this@BaseActivity, msg, Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun showProgress() = BaseProgress().show(supportFragmentManager, PROGRESS)

    fun hideProgress() =
        supportFragmentManager.fragments.filterIsInstance<BaseProgress>().forEach { it.dismiss() }

    companion object {
        private const val PROGRESS = "Progress"
    }
}