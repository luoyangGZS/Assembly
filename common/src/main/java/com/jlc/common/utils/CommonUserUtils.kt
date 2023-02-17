package com.jlc.common.utils

import android.text.TextUtils
import com.google.gson.Gson
import com.jlc.common.data.UserInfo
import com.jlc.common.utils.DataStoreUtils.getSyncData
import com.jlc.common.utils.DataStoreUtils.putSyncData

/**
 *
 *
 * @author lixiongjun
 * @date 2023/2/16
 */
class CommonUserUtils {
    companion object {
        // 懒加载
        val instance by lazy(LazyThreadSafetyMode.NONE) {
            CommonUserUtils()
        }
    }

    /**
     * 获取存储的用户信息，请根据实际业务进行返回,当前仅用于测试
     */
    fun getUser(): UserInfo? {
        //获取用户信息后，转成需要的对象
        val userJson = getSyncData("userInfoJson", "")
        if (TextUtils.isEmpty(userJson)) {
            return null
        }
        return Gson().fromJson(userJson, UserInfo::class.java)
    }

    /**
     * 保存用户数据，请以实际为准
     */
    fun setUser(json: String) {
        //存储用户信息
        putSyncData("userInfoJson", json)

    }

    /**
     * 是否登录，实际业务中，根据存储的用户信息判断
     */
    fun isLogin(): Boolean {
        var userInfo = getUser()
        if (userInfo?.data != null && !TextUtils.isEmpty(userInfo.data.Id)) {
            return true
        }
        return false
    }
}