@file:JvmName("LoginHandler")

package com.dylanc.arouter

import android.app.Activity

/**
 * @author Dylan Cai
 */
internal var loginObserver: (() -> Unit)? = null

@JvmName("post")
fun Activity.loginSuccess() {
  val path = intent.getStringExtra(KEY_ROUTER_PATH)
  if (path != null) {
    startRouterActivity(path, extras = intent.extras) { finish() }
  } else {
    finish()
  }
  loginObserver?.invoke()
  loginObserver = null
}