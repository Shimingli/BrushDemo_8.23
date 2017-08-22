package imageloader.shiming.com.myapplication.views.doodleview.opereation;

import android.graphics.Canvas;
import android.graphics.Rect;

import imageloader.shiming.com.myapplication.manager.commandmanager.ICommand;
import imageloader.shiming.com.myapplication.manager.modelmager.IModelManager;
import imageloader.shiming.com.myapplication.manager.virsualmanager.IVisualManager;
import imageloader.shiming.com.myapplication.views.doodleview.FrameCache;
import imageloader.shiming.com.myapplication.views.doodleview.drawstrategy.RedrawStrategy;


/**
 * Created by $ zhoudeheng on 2015/12/8.
 * Email zhoudeheng@qccr.com
 */
public class DrawAllOperation extends DoodleOperation {

    public DrawAllOperation(FrameCache frameCache, IModelManager modelManager,
                            IVisualManager visualManager) {
        super(frameCache, modelManager, visualManager);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        RedrawStrategy drawStrategy = new RedrawStrategy(canvas, mFrameCache,
                null, mModelManager.getInsertableObjectList(), mVisualManager);
        drawStrategy.draw();
    }

    @Override
    public ICommand onCreateCommand() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Rect computerDirty() {
        // TODO Auto-generated method stub
        return null;
    }
}
