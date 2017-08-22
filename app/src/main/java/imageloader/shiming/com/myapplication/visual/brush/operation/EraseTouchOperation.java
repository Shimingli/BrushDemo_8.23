package imageloader.shiming.com.myapplication.visual.brush.operation;

import android.view.MotionEvent;

import imageloader.shiming.com.myapplication.manager.commandmanager.AddedCommand;
import imageloader.shiming.com.myapplication.manager.commandmanager.ICommand;
import imageloader.shiming.com.myapplication.manager.modelmager.IModelManager;
import imageloader.shiming.com.myapplication.manager.virsualmanager.IVisualManager;
import imageloader.shiming.com.myapplication.model.stroke.InsertableObjectStroke;
import imageloader.shiming.com.myapplication.views.doodleview.FrameCache;
import imageloader.shiming.com.myapplication.visual.brush.VisualStrokeErase;


/**
 * Created by $ zhoudeheng on 2015/12/9.
 * Email zhoudeheng@qccr.com
 */
public class EraseTouchOperation extends StrokeTouchOperation {
    protected VisualStrokeErase mVisualStrokeErase;

    public EraseTouchOperation(FrameCache frameCache,
                               IModelManager modelManager, IVisualManager visualManager,
                               InsertableObjectStroke stroke) {
        super(frameCache, modelManager, visualManager, stroke);
        // TODO Auto-generated constructor stub
        mVisualStrokeErase = (VisualStrokeErase) mVisualStroke;
    }

    @Override
    public ICommand onCreateCommand() {
        // TODO Auto-generated method stub
        ICommand command = null;
        if (mMotionEvent.getActionMasked() == MotionEvent.ACTION_UP
                && mVisualStrokeErase.intersects()) {
            command = new AddedCommand(mStroke, mModelManager);
        }
        return command;
    }

}
