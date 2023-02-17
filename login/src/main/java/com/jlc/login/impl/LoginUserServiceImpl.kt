package com.jlc.login.impl

import android.app.AlertDialog
import android.content.Context
import android.text.TextUtils
import com.alibaba.android.arouter.facade.annotation.Route
import com.google.gson.Gson
import com.jlc.common.data.UserInfo
import com.jlc.common.router.CommonRouterConstant
import com.jlc.common.service.AccountUserService
import com.jlc.common.utils.DataStoreUtils

/**
 *
 *
 * @author lixiongjun
 * @date 2023/2/16
 */
@Route(path = CommonRouterConstant.USER_INFO, name = "LoginUserServiceImpl")
class LoginUserServiceImpl : AccountUserService{

    override fun getUser(): UserInfo? {
        //获取用户信息后，转成需要的对象
        val userJson = DataStoreUtils.getSyncData("userInfoJson", "")
        if (TextUtils.isEmpty(userJson)) {
            return null
        }
        return Gson().fromJson(userJson, UserInfo::class.java)
    }

    /**
     * INTRODUCE:测试弹窗或其他功能
     */
    override fun showDialog() {
        AlertDialog.Builder(mContext)
            .setTitle("测试一个Dialog弹出框")
            .setMessage("简单测试以下")
            .setNegativeButton("取消") { _, _ ->

            }
            .setPositiveButton("确定") { _, _ ->


            }
            .show()
    }

    private var mContext: Context? = null

    override fun init(context: Context?) {
        mContext = context
    }
}