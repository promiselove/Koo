package com.yuxin.koo;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {
    /**
     * fragmentTabHost
     */
    private FragmentTabHost fragmentTabHost;
    /**
     * 布局填充器
     */
    private LayoutInflater layoutInflater;
    /**
     * 存放图片数组
     *
     */
    private int mImageArray[] = { R.drawable.tab_home_btn,
            R.drawable.tab_message_btn, R.drawable.tab_selfinfo_btn,
            R.drawable.tab_square_btn, R.drawable.tab_more_btn };
    /**
     * fragment数组页面
     */
    private Class fragmentArray[] = {FragmentPage1.class,FragmentPage2.class,FragmentPage3.class,FragmentPage4.class,FragmentPage5.class};
    /**
     * 选项卡文字
     */
    private String mTextViewArray[] ={"首页", "消息", "好友", "搜索", "更多"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitView();
    }

    private void InitView(){
        layoutInflater = LayoutInflater.from(this);
        fragmentTabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);
        fragmentTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

        int count = fragmentArray.length;
        for (int i = 0;i < count; i++){
            TabHost.TabSpec tabSpec = fragmentTabHost.newTabSpec(mTextViewArray[i]).setIndicator(getTabItemView(i));
            fragmentTabHost.addTab(tabSpec, fragmentArray[i], null);
            // 设置Tab按钮的背景
            fragmentTabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.selector_tab_background);
        }
}

    /**
     * 给Tab按钮设置图标和文字
     */
    private View getTabItemView(int index){
        View view = layoutInflater.inflate(R.layout.tab_item_view, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        imageView.setImageResource(mImageArray[index]);
        TextView textView = (TextView) view.findViewById(R.id.textView);
        textView.setText(mTextViewArray[index]);

        return view;
    }
}
