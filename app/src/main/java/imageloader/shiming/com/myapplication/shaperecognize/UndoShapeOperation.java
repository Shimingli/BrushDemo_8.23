package imageloader.shiming.com.myapplication.shaperecognize;

import java.util.List;

import imageloader.shiming.com.myapplication.manager.commandmanager.ICommand;
import imageloader.shiming.com.myapplication.model.InsertableObjectBase;
import imageloader.shiming.com.myapplication.views.doodleview.IInternalDoodle;

/**
 * Created by $ zhoudeheng on 2015/12/9.
 * Email zhoudeheng@qccr.com
 */
public class UndoShapeOperation extends ShapeRecognizeOperation {
    public UndoShapeOperation(IInternalDoodle internalDoodle,
                              List<InsertableObjectBase> list, int shapeDocIndex) {
        super(internalDoodle, list, shapeDocIndex);
        // TODO Auto-generated constructor stub
    }

    @Override
    public ICommand onCreateCommand() {
        return null;
    }

}