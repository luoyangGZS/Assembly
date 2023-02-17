package com.jlc.login

import com.jlc.common.CommonApp

/**
 *
 *
 * @author lixiongjun
 * @date 2023/2/17
 */
class LoginApplication : CommonApp() {
    override fun isDebug(): Boolean {
        return BuildConfig.DEBUG
    }
}