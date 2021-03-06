package imageloader.shiming.com.myapplication.listeners;

import android.graphics.Matrix;

import imageloader.shiming.com.myapplication.model.InsertableObjectBase;


/**
 * Created by $ zhoudeheng on 2015/12/8.
 * Email zhoudeheng@qccr.com
 * 定义用户旋转，平移，缩放时候的回调。
 */
public interface ITransformChangedListener {
    void onScaled(InsertableObjectBase insertableObject, Matrix matrix);

    void onTranslate(InsertableObjectBase insertableObject, Matrix matrix);

    void onRotate(InsertableObjectBase insertableObject, Matrix matrix);
}
