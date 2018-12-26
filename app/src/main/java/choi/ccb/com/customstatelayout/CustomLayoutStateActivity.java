package choi.ccb.com.customstatelayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import choi.ccb.com.morestatelayout.CustomStateLayout;


public class CustomLayoutStateActivity extends AppCompatActivity implements View.OnClickListener {

    private CustomStateLayout customLayoutRelativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_layout_state);
        customLayoutRelativeLayout = (CustomStateLayout) findViewById(R.id.customRl);

        findViewById(R.id.bt1).setOnClickListener(this);
        findViewById(R.id.bt2).setOnClickListener(this);
        findViewById(R.id.bt3).setOnClickListener(this);
        findViewById(R.id.bt4).setOnClickListener(this);
        findViewById(R.id.bt5).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt1:
                customLayoutRelativeLayout.hideAllState();
                break;
            case R.id.bt2:
                customLayoutRelativeLayout.showLoadIng();
                break;
            case R.id.bt3:
                customLayoutRelativeLayout.showLoadFail();
                break;
            case R.id.bt4:
                customLayoutRelativeLayout.showLoadError();
                break;
            case R.id.bt5:
                customLayoutRelativeLayout.showLoadEmpty();
                break;
        }
    }
}
