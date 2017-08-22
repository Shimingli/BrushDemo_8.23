package imageloader.shiming.com.myapplication.views.selectview;

import android.content.Context;
import android.view.View;

import imageloader.shiming.com.myapplication.model.InsertableObjectBase;


/**
 * Created by $ zhoudeheng on 2015/12/9.
 * Email zhoudeheng@qccr.com
 */
public class SelectViewFactory {
    public static ISelectView<InsertableObjectBase>  createSelectView(Context context, View objectParent, InsertableObjectBase data){
        return new SelectViewTwoDrag(context, data, objectParent);
    }
}
