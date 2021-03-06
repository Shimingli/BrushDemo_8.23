package imageloader.shiming.com.myapplication.listeners;


import java.util.List;

import imageloader.shiming.com.myapplication.model.InsertableObjectBase;

/**
 * Created by $ zhoudeheng on 2015/12/8.
 * Email zhoudeheng@qccr.com
 * 可插入对象改变(增加，删除)时候的回调
 */
public interface IIsertableObjectListener {
    void onAdded(List<InsertableObjectBase> list,
                 boolean fromUndoRedo);

    void onRemoved(List<InsertableObjectBase> list,
                   boolean fromUndoRedo);

    void onClear();

    void onClearStrokes();

    void onRecognizeAdd();
}
