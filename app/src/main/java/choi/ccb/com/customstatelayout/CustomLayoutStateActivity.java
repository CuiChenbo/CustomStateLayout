package choi.ccb.com.customstatelayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import choi.ccb.com.morestatelayout.CustomStateLayout;


public class CustomLayoutStateActivity extends AppCompatActivity implements View.OnClickListener {

    private CustomStateLayout mCustomStateLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_layout_state);
        mCustomStateLayout = (CustomStateLayout) findViewById(R.id.customRl);

        findViewById(R.id.bt1).setOnClickListener(this);
        findViewById(R.id.bt2).setOnClickListener(this);
        findViewById(R.id.bt3).setOnClickListener(this);
        findViewById(R.id.bt4).setOnClickListener(this);
        findViewById(R.id.bt5).setOnClickListener(this);
        mCustomStateLayout.setLayoutClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CustomLayoutStateActivity.this,"点我",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt1:
                mCustomStateLayout.hideAllState();
                break;
            case R.id.bt2:
                mCustomStateLayout.showLoadIng();
                break;
            case R.id.bt3:
                mCustomStateLayout.showLoadFail();
                break;
            case R.id.bt4:
                mCustomStateLayout.showLoadError();
                break;
            case R.id.bt5:
                mCustomStateLayout.showLoadEmpty();
                break;
        }
    }
}
