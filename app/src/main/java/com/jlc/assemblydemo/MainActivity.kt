package com.jlc.assemblydemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.jlc.common.router.CommonRouterConstant
import com.jlc.common.router.CommonRouterManger

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //模拟跳转login组件
        findViewById<Button>(R.id.btn_account).setOnClickListener {
            CommonRouterManger.instance.navigationActivity(CommonRouterConstant.LOGIN)
        }

        //模拟跳转shopping组件 navigationActivityParams
        findViewById<Button>(R.id.btn_code).setOnClickListener {
            CommonRouterManger.instance.navigationActivityParams(CommonRouterConstant.SHOPPING,"params" to "首页携带的数据",
            "params2" to 100000)
        }
    }
}