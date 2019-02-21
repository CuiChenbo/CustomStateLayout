package choi.ccb.com.customstatelayout.view;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import choi.ccb.com.customstatelayout.R;

public class TopDialog extends DialogFragment {

    private LinearLayout ll;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
       View dialogView = inflater.inflate(R.layout.top_dialog,container);
       ll = dialogView.findViewById(R.id.mView);
       FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) ll.getLayoutParams();
       params.topMargin = getStatusBarHeight(getDialog().getContext());
       ll.setLayoutParams(params);
        return dialogView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE,R.style.DialogFullScreen); //dialog全屏
    }


    @Override
    public void onStart() {
        super.onStart();
        Window window = getDialog().getWindow();
        WindowManager.LayoutParams windowParams = window.getAttributes();
        windowParams.dimAmount = 0.0f;//Dialog外边框透明
        window.setLayout(-1, -2); //高度自适应，宽度全屏
        windowParams.gravity = Gravity.TOP; //在顶部显示
        window.setAttributes(windowParams);
    }

    /**
     * 获取状态栏高度（单位：px）
     */
    public static int getStatusBarHeight(Context context) {
        Resources resources = context.getResources();
        int resourceId = resources.getIdentifier("status_bar_height", "dimen", "android");
        return resources.getDimensionPixelSize(resourceId) == 0 ? 60 : resources.getDimensionPixelSize(resourceId);
    }

}
