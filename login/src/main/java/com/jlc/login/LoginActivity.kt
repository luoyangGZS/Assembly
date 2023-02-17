package com.jlc.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.alibaba.android.arouter.facade.annotation.Route
import com.jlc.common.router.CommonRouterConstant
import com.jlc.common.router.CommonRouterManger
import com.jlc.common.utils.CommonUserUtils

@Route(path = CommonRouterConstant.LOGIN)
class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //普通页面跳转
        findViewById<Button>(R.id.btn_code).setOnClickListener {
            CommonRouterManger.instance.navigationActivity(CommonRouterConstant.SHOPPING)
        }
        //页面带参数跳转
        findViewById<Button>(R.id.btn_code_params).setOnClickListener {
            CommonRouterManger.instance.navigationActivityParams(
                CommonRouterConstant.SHOPPING,
                "params" to "登录页携带的参数",
                "params2" to 10100000
            )
        }

        //模拟登录，真实业务中，请以实际为准，目前只是测试
        findViewById<Button>(R.id.btn_login).setOnClickListener {
            //登录成功之后，保存用户信息，格式自定义，请以实际为准,当前为Demo测试
            val json = "{\n" +
                    "\t\"code\": 0,\n" +
                    "\t\"message\": \"登录成功\",\n" +
                    "\t\"data\": {\n" +
                    "\t\t\"userName\": \"luoyang\",\n" +
                    "\t\t\"userId\": \"1231232331\",\n" +
                    "\t\t\"nickName\": \"洛阳\"\n" +
                    "\t}\n" +
                    "}"
            CommonUserUtils.instance.setUser(json)
            Toast.makeText(this, "模拟登录成功", Toast.LENGTH_SHORT).show()
        }
    }
}