package c.r.myapplication.ui.base

import android.app.ProgressDialog
import android.content.Context
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import c.r.myapplication.utils.DialogUtil
import com.google.android.material.snackbar.Snackbar

/**
 * Created by Handi Komara.
 * handikomara22@gmail.com
 */

open abstract class BaseActivity : AppCompatActivity(), IBaseView {

    protected var mProgressDialog: ProgressDialog? = null

    override fun showLoading() {

        hideLoading()
        mProgressDialog = DialogUtil.showLoadingDialog(this)
    }

    override fun hideLoading() {

        if (mProgressDialog != null && mProgressDialog!!.isShowing) {
            mProgressDialog?.cancel()
        }

    }

    override fun showError(errorMessage: String) {

        Snackbar.make(findViewById(android.R.id.content), errorMessage, Snackbar.LENGTH_LONG)
                .show()

    }

    override fun showError(errorId: Int) {

        Snackbar.make(findViewById(android.R.id.content), getString(errorId), Snackbar.LENGTH_LONG)
                .show()
    }

    fun hideKeyboard() {

        val view = this.currentFocus

        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }

    }

    protected abstract fun setUp()
}