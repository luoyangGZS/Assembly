package com.jlc.assemblydemo

import androidx.viewbinding.BuildConfig
import com.jlc.common.CommonApp

/**
 *
 *
 * @author lixiongjun
 * @date 2023/2/16
 */
class MApplication : CommonApp() {
    override fun isDebug(): Boolean {
        return BuildConfig.DEBUG
    }
}