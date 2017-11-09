package com.example.leo.simplemvp.base;

/**
 * @author lei.han
 * @time 2017/11/9 上午11:21
 */
public abstract class BaseMvpPresenter<V extends BaseMvpView> implements Presenter<V> {

    private V mvpView;

    @Override
    public void attachView(V mvpView) {
        this.mvpView = mvpView;
    }

    @Override
    public void detachView() {
        this.mvpView = null;
    }

    /**
     * 判断view是否为空
     *
     * @return
     */
    public boolean isAttachView() {
        return mvpView != null;
    }

    /**
     * 返回目标view
     */
    public V getMvpView() {
        return mvpView;
    }

    /**
     * 检查view和presenter是否连接
     */
    public void checkViewAttach() {
        if (!isAttachView()) {
            throw new MvpViewNotAttachedException();
        }
    }

    public static class MvpViewNotAttachedException extends RuntimeException {

        public MvpViewNotAttachedException() {
            super("请求数据前请先调用attachView(MvpView)方法与View建立连接");
        }
    }
}
