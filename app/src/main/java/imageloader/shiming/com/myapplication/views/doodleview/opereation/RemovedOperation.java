package imageloader.shiming.com.myapplication.views.doodleview.opereation;


import imageloader.shiming.com.myapplication.manager.commandmanager.ICommand;
import imageloader.shiming.com.myapplication.manager.commandmanager.RemovedCommand;
import imageloader.shiming.com.myapplication.manager.modelmager.IModelManager;
import imageloader.shiming.com.myapplication.manager.virsualmanager.IVisualManager;
import imageloader.shiming.com.myapplication.model.InsertableObjectBase;
import imageloader.shiming.com.myapplication.views.doodleview.FrameCache;

/**
 * Created by $ zhoudeheng on 2015/12/8.
 * Email zhoudeheng@qccr.com
 */
public class RemovedOperation extends DrawAllOperation {
    protected InsertableObjectBase mRemovedObject;

    public RemovedOperation(FrameCache frameCache, IModelManager modelManager,
                            IVisualManager visualManager, InsertableObjectBase removedObject) {
        super(frameCache, modelManager, visualManager);
        // TODO Auto-generated constructor stub
        mRemovedObject = removedObject;
    }

    @Override
    public ICommand onCreateCommand() {
        // TODO Auto-generated method stub
        return new RemovedCommand(mRemovedObject, mModelManager);
        // return null;
    }

}