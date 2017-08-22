package imageloader.shiming.com.myapplication.model.stroke;

import android.content.Context;
import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;

import imageloader.shiming.com.myapplication.model.InsertableObjectBase;
import imageloader.shiming.com.myapplication.model.propertyconfig.PropertyConfigBase;
import imageloader.shiming.com.myapplication.model.propertyconfig.PropertyConfigStroke;
import imageloader.shiming.com.myapplication.utils.ErrorUtil;
import imageloader.shiming.com.myapplication.utils.PropertyConfigStrokeUtils;
import imageloader.shiming.com.myapplication.views.doodleview.IInternalDoodle;
import imageloader.shiming.com.myapplication.visual.VisualElementBase;
import imageloader.shiming.com.myapplication.visual.brush.VisualStrokeAirBursh;
import imageloader.shiming.com.myapplication.visual.brush.VisualStrokeBrush;
import imageloader.shiming.com.myapplication.visual.brush.VisualStrokeErase;
import imageloader.shiming.com.myapplication.visual.brush.VisualStrokeMarker;
import imageloader.shiming.com.myapplication.visual.brush.VisualStrokePath;
import imageloader.shiming.com.myapplication.visual.brush.VisualStrokePen;
import imageloader.shiming.com.myapplication.visual.brush.VisualStrokePencil;


/**
 * Created by $ zhoudeheng on 2015/12/8.
 * Email zhoudeheng@qccr.com
 * 定义画笔的可插入对象
 * 工厂模式
 * InsertableObjectStroke是画笔数据层的基类
 */
public class InsertableObjectStroke extends InsertableObjectBase {
    /**
     * 橡皮擦
     */
    public static final int STROKE_TYPE_ERASER = 0;
    /**
     * 圆珠笔
     */
    public static final int STROKE_TYPE_NORMAL = 1;// 圆珠笔
    /**
     * 钢笔
     */
    public static final int STROKE_TYPE_PEN = 2;// 钢笔
    /**
     * 毛笔
     */
    public static final int STROKE_TYPE_BRUSH = 3;// 毛笔
    /**
     * 铅笔
     */
    public static final int STROKE_TYPE_PENCIL = 4;// 铅笔
    /**
     * 记号笔
     */
    public static final int STROKE_TYPE_MARKER = 5;// 记号笔
    /**
     * 喷枪
     */
    public static final int STROKE_TYPE_AIRBRUSH = 6;// 喷枪

    public static final int PROPERTY_ID_STROKE_WIDTH = 101;
    public static final int PROPERTY_ID_STROKE_COLOR = 102;
    public static final int PROPERTY_ID_STROKE_ALPHA = 103;
    /**
     * 画笔类型
     */
    protected int mStrokeType = STROKE_TYPE_NORMAL;
    protected float mStrokeWidth = 20;// 画笔宽度
    protected int mColor = Color.RED;
    /**
     * 透明度 0-255
     */
    protected int mAlpha = 255;

    protected List<StylusPoint> mPoints;

    public InsertableObjectStroke(int strokeType) {
        super(InsertableObjectBase.TYPE_STROKE);
        // TODO Auto-generated constructor stub
        mStrokeType = strokeType;
        mPoints = new ArrayList<StylusPoint>();
    }

    @Override
    public VisualElementBase createVisualElement(Context context,
                                                 IInternalDoodle internalDoodle) {
        // TODO Auto-generated method stub
        VisualElementBase visualElement = null;
        switch (this.mStrokeType) {
            case STROKE_TYPE_ERASER:
                visualElement = new VisualStrokeErase(context, internalDoodle, this);
                break;
            case STROKE_TYPE_NORMAL:
                visualElement = new VisualStrokePath(context, internalDoodle, this);
                break;
            case STROKE_TYPE_AIRBRUSH:
                visualElement = new VisualStrokeAirBursh(context, internalDoodle,
                        this);
                break;
            case STROKE_TYPE_PENCIL:
                visualElement = new VisualStrokePencil(context, internalDoodle,
                        this);
                break;
            case STROKE_TYPE_PEN:
                visualElement = new VisualStrokePen(context, internalDoodle, this);
                break;
            case STROKE_TYPE_BRUSH:
                visualElement = new VisualStrokeBrush(context, internalDoodle, this);
                break;
            case STROKE_TYPE_MARKER:
                visualElement = new VisualStrokeMarker(context, internalDoodle,
                        this);
                break;
            default:
                break;
        }
        return visualElement;
    }

    public int getStrokeType() {
        return mStrokeType;
    }

    public float getStrokeWidth() {
        return mStrokeWidth;
    }

    public void setStrokeWidth(float mStrokeWidth) {
        if (this.mStrokeWidth != mStrokeWidth) {
            float temp = this.mStrokeWidth;
            this.mStrokeWidth = mStrokeWidth;
            firePropertyChanged(PROPERTY_ID_STROKE_WIDTH, temp, mStrokeWidth);
        }
    }

    public int getColor() {
        return mColor;
    }

    public void setColor(int mColor) {
        if (this.mColor != mColor) {
            float temp = this.mColor;
            this.mColor = mColor;
            firePropertyChanged(PROPERTY_ID_STROKE_COLOR, temp, mColor);
        }
    }

    public int getAlpha() {
        return mAlpha;
    }

    public void setAlpha(int mAlpha) {
        if (this.mAlpha != mAlpha) {
            float temp = this.mAlpha;
            this.mAlpha = mAlpha;
            firePropertyChanged(PROPERTY_ID_STROKE_COLOR, temp, mAlpha);
        }
    }

    public List<StylusPoint> getPoints() {
        return mPoints;
    }

    public void setPoints(List<StylusPoint> mPoints) {
        this.mPoints = mPoints;
    }

    @Override
    public PropertyConfigBase getPropertyConfig() {
        // TODO Auto-generated method stub
        return null;
    }

    public static boolean isSupported(int type) {
        return type >= STROKE_TYPE_ERASER && type <= STROKE_TYPE_AIRBRUSH;
    }

    @Override
    public boolean canErased() {
        // TODO Auto-generated method stub
        if (mStrokeType == STROKE_TYPE_ERASER)
            return false;
        return true;
    }

    public static InsertableObjectStroke newInsertableObjectStroke(int type) {
        if (!isSupported(type)) {
            throw ErrorUtil.getStrokeTypeNoteSupportedError(type);
        }
        PropertyConfigStroke configStroke = PropertyConfigStrokeUtils
                .getPropertyConfigStroke(type);
        InsertableObjectStroke stroke = new InsertableObjectStroke(type);
        stroke.setAlpha(configStroke.getAlpha());
        stroke.setColor(configStroke.getColor());
        stroke.setStrokeWidth(configStroke.getStrokeWidth());
        return stroke;
    }

    @Override
    public boolean isSelectable() {
        // TODO Auto-generated method stub
        return false;
    }
}
