package com.example.filemanager.ui.dialog

import android.os.Bundle
import android.view.View
import com.example.filemanager.R
import com.example.filemanager.databinding.DialogDeniedPermissionBinding
import com.example.filemanager.ui.base.BaseBindingDialogFragment
import com.example.filemanager.util.ViewUtil

class DeniedPermissionDialogFragment : BaseBindingDialogFragment<DialogDeniedPermissionBinding>() {

    var textContent: String = ""
    var iClickDeniedPermission: IClickDeniedPermission? = null

    override fun getLayoutId(): Int {
        return R.layout.dialog_denied_permission
    }

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
        initView()
        initListener()
    }

    private fun initView() {
        binding.txtContent.text = textContent

    }

    private fun initListener() {
        binding.tvCancel.setOnClickListener {
            ViewUtil.preventTwoClick(it, 500)
            iClickDeniedPermission?.clickCancel()
            dismiss()
        }

        binding.btnOk.setOnClickListener {
            ViewUtil.preventTwoClick(it, 500)
            iClickDeniedPermission?.clickDone()
        }

    }

    interface IClickDeniedPermission {
        fun clickCancel()
        fun clickDone()
    }
}