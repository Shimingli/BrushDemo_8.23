package imageloader.shiming.com.myapplication.listeners;


import imageloader.shiming.com.myapplication.views.doodleview.DoodleEnum;

/**
 * Created by $ zhoudeheng on 2015/12/8.
 * Email zhoudeheng@qccr.com
 */
public interface ISelectionModeChangedListener {
    void onSelectionModeChanged(DoodleEnum.SelectionMode oldValue,
                                DoodleEnum.SelectionMode newValue);
}
