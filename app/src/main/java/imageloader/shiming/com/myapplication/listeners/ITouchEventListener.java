package imageloader.shiming.com.myapplication.listeners;

import android.view.MotionEvent;

import imageloader.shiming.com.myapplication.model.InsertableObjectBase;


/**
 * Created by $ zhoudeheng on 2015/12/8.
 * Email zhoudeheng@qccr.com
 * 触摸屏事件回调
 */
public interface ITouchEventListener {
    boolean onTouchEvent(MotionEvent event,
                         InsertableObjectBase actingInsertableObject);
}
