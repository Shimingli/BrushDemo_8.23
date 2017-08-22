package imageloader.shiming.com.myapplication.views.doodleview.drawstrategy;

import android.graphics.Canvas;

import imageloader.shiming.com.myapplication.views.doodleview.FrameCache;
import imageloader.shiming.com.myapplication.visual.VisualElementBase;


/**
 * Created by $ zhoudeheng on 2015/12/8.
 * Email zhoudeheng@qccr.com
 * 该策略较通用,例如编辑图片的操作，应该使用该策略
 * 绘制缓存，绘制visual element
 */
public class EditDrawStrategy extends DrawStrategy {

    public EditDrawStrategy(Canvas canvas, FrameCache frameCache,
                            VisualElementBase visualElement) {
        super(canvas, frameCache, visualElement);
    }

    @Override
    public void draw() {
        // TODO Auto-generated method stub
        drawCache();
        drawVisualElement();
    }

    @Override
    protected void updateCache() {
        // TODO Auto-generated method stub

    }
}