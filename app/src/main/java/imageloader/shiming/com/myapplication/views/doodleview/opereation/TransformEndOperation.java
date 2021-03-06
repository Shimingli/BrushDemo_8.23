package imageloader.shiming.com.myapplication.views.doodleview.opereation;

import android.graphics.Matrix;

import imageloader.shiming.com.myapplication.manager.commandmanager.ICommand;
import imageloader.shiming.com.myapplication.manager.commandmanager.TransformEndCommand;
import imageloader.shiming.com.myapplication.manager.modelmager.IModelManager;
import imageloader.shiming.com.myapplication.manager.virsualmanager.IVisualManager;
import imageloader.shiming.com.myapplication.model.InsertableObjectBase;
import imageloader.shiming.com.myapplication.views.doodleview.FrameCache;


/**
 * Created by $ zhoudeheng on 2015/12/9.
 * Email zhoudeheng@qccr.com
 */
public class TransformEndOperation extends TransformingOperation {
    protected Matrix mOldMatrix = null;

    public TransformEndOperation(FrameCache frameCache,
                                 IModelManager modelManager, IVisualManager visualManager,
                                 InsertableObjectBase insertableObject, Matrix oldMatrix) {
        super(frameCache, modelManager, visualManager, insertableObject);
        // TODO Auto-generated constructor stub
        mOldMatrix = oldMatrix;
    }

    @Override
    public ICommand onCreateCommand() {
        // TODO Auto-generated method stub
        return new TransformEndCommand(mData, mOldMatrix);
    }
}