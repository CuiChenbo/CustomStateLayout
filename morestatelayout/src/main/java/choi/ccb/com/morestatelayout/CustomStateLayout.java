package choi.ccb.com.morestatelayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 * ChenboCui
 */
public class CustomStateLayout extends RelativeLayout implements View.OnClickListener {

    private Context context;
    private final int NORMAL = 0;    //常规状态
    private final int LOADING = 1;   //加载中状态
    private final int LOADFAIL = 2;  //加载失败状态
    private final int LOADERROR = 3; //加载错误状态
    private final int LOADEMPTY = 4; //内容为空状态

    public CustomStateLayout(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public CustomStateLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public CustomStateLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }


    private RelativeLayout RelativeLayoutLoadIng,RelativeLayoutLoadFin,RelativeLayoutLoadError,RelativeLayoutLoadEmpty;

    private LayoutInflater inflate;
    private void init(){
        inflate = LayoutInflater.from(context);
        setOnClickListener(this);
    }



    private void setLoadFail(){
       if (RelativeLayoutLoadFin == null){
           View v = this.inflate.inflate(R.layout.custom_loadfail,null);
           RelativeLayoutLoadFin = v.findViewById(R.id.loadFin);
           this.addView(RelativeLayoutLoadFin,new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
       }else{
           RelativeLayoutLoadFin.setVisibility(VISIBLE);
       }
    }

    private void setLoadIng(){
        if (RelativeLayoutLoadIng == null){
            View v = this.inflate.inflate(R.layout.custom_loading,null);
            RelativeLayoutLoadIng = v.findViewById(R.id.loadIng);
            this.addView(RelativeLayoutLoadIng,new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
        }else{
            RelativeLayoutLoadIng.setVisibility(VISIBLE);
        }
    }


    private void setLoadError(){
        if (RelativeLayoutLoadError == null){
            View v = this.inflate.inflate(R.layout.custom_loaderror,null);
            RelativeLayoutLoadError = v.findViewById(R.id.loadError);
            this.addView(RelativeLayoutLoadError,new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
        }else{
            RelativeLayoutLoadError.setVisibility(VISIBLE);
        }
    }

    private void setLoadEmpty(){
        if (RelativeLayoutLoadEmpty == null){
            View v = this.inflate.inflate(R.layout.custom_loadempty,null);
            RelativeLayoutLoadEmpty = v.findViewById(R.id.loadEmpty);
            this.addView(RelativeLayoutLoadEmpty,new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
        }else{
            RelativeLayoutLoadEmpty.setVisibility(VISIBLE);
        }
    }

    private void hideLoadFail(){
        if (RelativeLayoutLoadFin != null){
            RelativeLayoutLoadFin.setVisibility(GONE);
        }
    }

    private void hideLoadIng(){
        if (RelativeLayoutLoadIng != null){
            RelativeLayoutLoadIng.setVisibility(GONE);
        }
    }

    private void hideLoadError(){
        if (RelativeLayoutLoadError != null){
            RelativeLayoutLoadError.setVisibility(GONE);
        }
    }

    private void hideLoadEmpty(){
        if (RelativeLayoutLoadEmpty != null){
            RelativeLayoutLoadEmpty.setVisibility(GONE);
        }
    }

    public void hideAllState(){
        setState(NORMAL);
    }

    public void showLoadIng(){
        setState(LOADING);
    }
    public void showLoadFail(){
        setState(LOADFAIL);
    }
    public void showLoadError(){
        setState(LOADERROR);
    }
    public void showLoadEmpty(){
        setState(LOADEMPTY);
    }


    private void setState(int state){
         switch (state){
             case NORMAL :
                 clickEnable = false;
                 hideLoadIng();
                 hideLoadFail();
                 hideLoadError();
                 hideLoadEmpty();
                 break;
             case LOADING :
                 clickEnable = false;
                 setLoadIng();
                 hideLoadFail();
                 hideLoadError();
                 hideLoadEmpty();
                 break;
             case LOADFAIL :
                 clickEnable = true;
                 hideLoadIng();
                 setLoadFail();
                 hideLoadError();
                 hideLoadEmpty();
                 break;
             case LOADERROR:
                 clickEnable = true;
                 hideLoadIng();
                 hideLoadFail();
                 setLoadError();
                 hideLoadEmpty();
                 break;
             case LOADEMPTY:
                 clickEnable = true;
                 hideLoadIng();
                 hideLoadFail();
                 hideLoadError();
                 setLoadEmpty();
                 break;
              default:
                  hideAllState();
                  break;
         }
    }

    @Override
    public void onClick(View view) {
        if (clickEnable){
            if (listener != null) {
                hideAllState();
                listener.onClick(view);
            }
        }
    }
    private boolean clickEnable = false;
    private View.OnClickListener listener;
    public void setLayoutClickListener(OnClickListener listener) {
        this.listener = listener;
    }
}
