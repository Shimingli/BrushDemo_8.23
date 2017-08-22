package imageloader.shiming.com.myapplication.manager.commandmanager;


import imageloader.shiming.com.myapplication.model.InsertableObjectBase;

/**
 * Created by $ zhoudeheng on 2015/12/8.
 * Email zhoudeheng@qccr.com
 * 定义ICommand接口，DoodleView的undo，redo功能由ICommand完成
 */
public interface ICommand {
    /**
     * 返回该Command对应的可插入对象
     *
     * @return
     */
    InsertableObjectBase getInsertObject();

    void undo();

    void redo();
}
