package top.saymzx.easycontrol.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import top.saymzx.easycontrol.app.databinding.ActivityActiveBinding;
import top.saymzx.easycontrol.app.helper.PublicTools;
import top.saymzx.easycontrol.app.helper.ViewTools;

public class ActiveActivity extends Activity {

    private ActivityActiveBinding activityActiveBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewTools.setStatusAndNavBar(this);
        ViewTools.setLocale(this);
        activityActiveBinding = ActivityActiveBinding.inflate(this.getLayoutInflater());
        setContentView(activityActiveBinding.getRoot());
        
        // 设置UI
        setUi();
    }

    private void setUi() {
        // 显示激活密钥
        activityActiveBinding.key.setText(AppData.setting.getActiveKey());
        
        // 设置捐赠链接点击事件
        activityActiveBinding.url.setOnClickListener(v -> 
            PublicTools.startUrl(this, "https://gitee.com/mingzhixianweb/easycontrol/blob/master/DONATE.md"));
        
        // 移除激活按钮功能
        activityActiveBinding.active.setVisibility(View.GONE);
        
        // 添加关闭按钮
        activityActiveBinding.closeButton.setVisibility(View.VISIBLE);
        activityActiveBinding.closeButton.setOnClickListener(v -> finish());
    }

    @Override
    public void onBackPressed() {
        // 允许返回
        finish();
    }
}
