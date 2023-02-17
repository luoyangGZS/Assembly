package com.jlc.shopping

import com.jlc.common.CommonApp

/**
 *
 *
 * @author lixiongjun
 * @date 2023/2/17
 */
class ShopApplication : CommonApp() {
    override fun isDebug(): Boolean {
        return BuildConfig.DEBUG
    }
}