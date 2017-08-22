package imageloader.shiming.com.myapplication.model;

import android.graphics.Matrix;

import imageloader.shiming.com.myapplication.manager.commandmanager.ICommand;
import imageloader.shiming.com.myapplication.manager.modelmager.IModelManager;
import imageloader.shiming.com.myapplication.manager.virsualmanager.IVisualManager;
import imageloader.shiming.com.myapplication.views.doodleview.FrameCache;
import imageloader.shiming.com.myapplication.views.doodleview.opereation.DrawAllOperation;


/**
 * Created by $ zhoudeheng on 2015/12/9.
 * Email zhoudeheng@qccr.com
 */
public class UnSelectedDrawAllOperation extends DrawAllOperation {
    protected InsertableObjectBase mInsertableObject;
    protected Matrix mUndoMatrix = null;
    protected Matrix mRedoMatrix = null;

    public UnSelectedDrawAllOperation(FrameCache frameCache,
                                      IModelManager modelManager, IVisualManager visualManager,
                                      InsertableObjectBase insertableObject, Matrix undoMatrix,
                                      Matrix redoMatrix) {
        super(frameCache, modelManager, visualManager);
        // TODO Auto-generated constructor stub
        mInsertableObject = insertableObject;
        mUndoMatrix = undoMatrix;
        mRedoMatrix = redoMatrix;
    }

    @Override
    public ICommand onCreateCommand() {
        // TODO Auto-generated method stub
        // if (mUndoMatrix == null || mRedoMatrix == null)
        // return null;
        // if (mUndoMatrix.equals(mRedoMatrix))
        // return null;
        // return new UnSelectedCommand(mInsertableObject, mUndoMatrix,
        // mRedoMatrix);
        return null;
    }
}

