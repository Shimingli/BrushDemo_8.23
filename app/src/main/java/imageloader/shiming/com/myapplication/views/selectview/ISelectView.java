package imageloader.shiming.com.myapplication.views.selectview;


import imageloader.shiming.com.myapplication.listeners.IClickedListener;
import imageloader.shiming.com.myapplication.listeners.IObjectUnSelectedListener;

/**
 * Created by $ zhoudeheng on 2015/12/9.
 * Email zhoudeheng@qccr.com
 */
public interface ISelectView<T> {
    void setUnSelectedListener(IObjectUnSelectedListener<T> listener);
    void setOnDeleteListener(IClickedListener listener);
    void setTransformChangedListener(ITransformChanged changed);
    void showSelectView();
    void dismissSelectView();
    boolean isSelectViewShowing();
}
