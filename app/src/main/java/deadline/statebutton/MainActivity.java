package deadline.statebutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    StateButton text;

    StateButton background;

    StateButton radius;

    StateButton stroke;

    StateButton dash;

    StateButton test1, test2, test3;

    StateButtonUtil util;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        test1 = (StateButton) findViewById(R.id.test1);
        test2 = (StateButton) findViewById(R.id.test2);
        test3 = (StateButton) findViewById(R.id.test3);
        test1.setTag(false);
        test2.setTag(false);
        test3.setTag(false);
        int white = getResources().getColor(android.R.color.white);
        int primary = getResources().getColor(R.color.colorPrimary);
        util = new StateButtonUtil(white, primary);
        util.set(test1);
        //无的排斥演示
//        test1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (!(boolean) test1.getTag()) {
//                    set(test2, false);
//                    set(test3, false);
//                }
//                set(test1);
//            }
//        });
//        test2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                set(test1, false);
//                set(test2);
//            }
//        });
//        test3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                set(test1, false);
//                set(test3);
//            }
//        });
        //单选演示
        test1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(boolean) test1.getTag()) {
                    util.set(test2, false);
                    util.set(test3, false);
                }
                util.set(test1, true);
            }
        });
        test2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(boolean) test2.getTag()) {
                    util.set(test1, false);
                    util.set(test3, false);
                }
                util.set(test2, true);
            }
        });
        test3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(boolean) test3.getTag()) {
                    util.set(test1, false);
                    util.set(test2, false);
                }
                util.set(test3, true);
            }
        });


        //设置不同状态下文字变色
        text = (StateButton) findViewById(R.id.text_test);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setEnabled(false);
            }
        });

        //最常用的设置不同背景
        background = (StateButton) findViewById(R.id.background_test);
        background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                background.setEnabled(false);
            }
        });

        //设置四个角不同的圆角
        radius = (StateButton) findViewById(R.id.different_radius_test);
        radius.setRadius(new float[]{0, 0, 20, 20, 40, 40, 60, 60});
        //设置不同状态下边框颜色，宽度
        stroke = (StateButton) findViewById(R.id.stroke_test);
        stroke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                util.set(stroke);
            }
        });

        //设置间断
        dash = (StateButton) findViewById(R.id.dash_test);
        dash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dash.setEnabled(false);
            }
        });
    }
}
