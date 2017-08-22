package imageloader.shiming.com.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import imageloader.shiming.com.myapplication.views.doodleview.DoodleView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DoodleView doodleView = new DoodleView(this,null);
//        doodleView.setInputMode(DoodleEnum.InputMode);
//        doodleView.setSelectionMode(DoodleEnum.SelectionMode.);
//        doodleView.setStrokeType(InsertableObjectStroke.STROKE_TYPE_BRUSH);
        setContentView(doodleView);
    }
}
