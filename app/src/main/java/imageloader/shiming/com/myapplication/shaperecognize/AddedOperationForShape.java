package imageloader.shiming.com.myapplication.shaperecognize;


import imageloader.shiming.com.myapplication.manager.commandmanager.ICommand;
import imageloader.shiming.com.myapplication.manager.modelmager.IModelManager;
import imageloader.shiming.com.myapplication.manager.virsualmanager.IVisualManager;
import imageloader.shiming.com.myapplication.model.InsertableObjectBase;
import imageloader.shiming.com.myapplication.views.doodleview.FrameCache;
import imageloader.shiming.com.myapplication.views.doodleview.opereation.AddedOperation;

/**
 * Created by $ zhoudeheng on 2015/12/9.
 * Email zhoudeheng@qccr.com
 */
public class AddedOperationForShape extends AddedOperation {
    public AddedOperationForShape(FrameCache frameCache,
                                  IModelManager modelManager, IVisualManager visualManager,
                                  InsertableObjectBase insertableObject) {
        super(frameCache, modelManager, visualManager, insertableObject);
    }

    @Override
    public ICommand onCreateCommand() {
        return null;
    }
}

