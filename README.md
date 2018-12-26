# CustomStateLayout
可定制状态布局，多种状态布局； 可用于网络加载时布局的变化；
 类库拿走即用，可以自己定制各种状态的UI；代码思路清晰，有兴趣下载下来看看；

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
    # 显示加载中布局
    # 显示加载失败布局
    # 显示加载错误布局
    # 显示加载为空布局
    # 取消所有状态
    
