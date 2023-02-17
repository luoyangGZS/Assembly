package com.jlc.common.service

import com.alibaba.android.arouter.facade.template.IProvider
import com.jlc.common.data.UserInfo

/**
 *
 *
 * @author lixiongjun
 * @date 2023/2/16
 */
interface AccountUserService:IProvider {
    /**
     * 获取用户信息
     */
    fun getUser():UserInfo?

    /**
     * 弹出Dialog
     */
    fun showDialog()
}