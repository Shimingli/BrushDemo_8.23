package imageloader.shiming.com.myapplication.visual.brush.operation;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;

import imageloader.shiming.com.myapplication.manager.commandmanager.AddedCommand;
import imageloader.shiming.com.myapplication.manager.commandmanager.ICommand;
import imageloader.shiming.com.myapplication.manager.modelmager.IModelManager;
import imageloader.shiming.com.myapplication.manager.virsualmanager.IVisualManager;
import imageloader.shiming.com.myapplication.model.stroke.InsertableObjectStroke;
import imageloader.shiming.com.myapplication.views.doodleview.FrameCache;
import imageloader.shiming.com.myapplication.views.doodleview.drawstrategy.AddElementDrawStrategy;
import imageloader.shiming.com.myapplication.views.doodleview.drawstrategy.DrawStrategy;
import imageloader.shiming.com.myapplication.views.doodleview.drawstrategy.EditDrawStrategy;
import imageloader.shiming.com.myapplication.views.doodleview.opereation.DoodleOperation;
import imageloader.shiming.com.myapplication.visual.VisualElementBase;
import imageloader.shiming.com.myapplication.visual.brush.VisualStrokeBase;


/**
 * Created by $ zhoudeheng on 2015/12/8.
 * Email zhoudeheng@qccr.com
 * 跟用户交互的时候，绘制非分段画笔的操作。
 * 如果从其他地方加载数据，绘制stroke，不能使用此类。
 */
public class StrokeTouchOperation extends DoodleOperation {
    public final static String TAG = "DrawStrokeOperation";
    protected MotionEvent mMotionEvent;
    protected InsertableObjectStroke mStroke;
    protected VisualStrokeBase mVisualStroke;

    public StrokeTouchOperation(FrameCache frameCache,
                                IModelManager modelManager, IVisualManager visualManager,
                                InsertableObjectStroke stroke) {
        super(frameCache, modelManager, visualManager);
        mStroke = stroke;
        // TODO Auto-generated constructor stub
        VisualElementBase visualElement = mVisualManager
                .getVisualElement(mStroke);
        mVisualStroke = (VisualStrokeBase) visualElement;
    }

    public MotionEvent getMotionEvent() {
        return mMotionEvent;
    }

    public void setMotionEvent(MotionEvent mMotionEvent) {
        this.mMotionEvent = mMotionEvent;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        DrawStrategy drawStrategy = createDrawStrategy(canvas, mFrameCache);
        if (drawStrategy != null)
            drawStrategy.draw();
    }

    protected DrawStrategy createDrawStrategy(Canvas canvas,
                                              FrameCache frameCache) {
        DrawStrategy drawStrategy = null;
        if (mMotionEvent.getActionMasked() == MotionEvent.ACTION_UP) {
            drawStrategy = new AddElementDrawStrategy(canvas, frameCache, mVisualStroke);
        } else if (mMotionEvent.getActionMasked() == MotionEvent.ACTION_DOWN
                || mMotionEvent.getActionMasked() == MotionEvent.ACTION_MOVE) {
            drawStrategy = new EditDrawStrategy(canvas, frameCache, mVisualStroke);
        }
        return drawStrategy;
    }

    @Override
    public ICommand onCreateCommand() {
        // TODO Auto-generated method stub
        ICommand command = null;
        if (mMotionEvent.getActionMasked() == MotionEvent.ACTION_UP) {
            command = new AddedCommand(mStroke, mModelManager);
        }
        return command;
    }

    @Override
    public Rect computerDirty() {
        // return null;// lockcanvas(Rect
        // // rect)中，如果rect不为null，该方法花费的时间较多。绘制一笔的过程中，Dirty区域，设置为null是合理的
        if (mVisualStroke == null)
            return null;
        Rect rect = null;
        RectF rectF = mVisualStroke.getBounds();
        if (rectF == null)
            return null;
        rect = new Rect((int) rectF.left, (int) rectF.top, (int) rectF.right,
                (int) rectF.bottom);
        return rect;
    }
}