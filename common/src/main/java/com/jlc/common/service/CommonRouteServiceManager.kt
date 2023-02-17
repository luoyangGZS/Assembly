package com.jlc.common.service

import android.text.TextUtils
import com.alibaba.android.arouter.facade.template.IProvider
import com.alibaba.android.arouter.launcher.ARouter
import java.lang.Exception

/**
 * 服务管理
 *
 * @author lixiongjun
 * @date 2023/2/16
 */
object CommonRouteServiceManager {

    /**
     * 模块间通过路径名称发现服务
     * */
    fun <T : IProvider?> provide(clz: Class<T>?, path: String?): T? {
        if (TextUtils.isEmpty(path)) {
            return null
        }
        var provider: IProvider? = null
        try {
            provider = ARouter.getInstance()
                .build(path)
                .navigation() as IProvider
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return provider as T?
    }


    /**
     * 模块间通过类名称发现服务
     * */
    fun <T : IProvider?> provide(clz: Class<T>?): T? {
        var provider: IProvider? = null
        try {
            provider = ARouter.getInstance().navigation(clz)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return provider as T?
    }

    /**
     * 获取服务.
     * @return T? 接口
     */
    inline fun <reified T : IProvider> getProvideService(): T? =
        ARouter.getInstance().navigation(T::class.java)
}