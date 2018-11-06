package cn.leo.magictextviewutil;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import cn.leo.magictextviewutil.utils.MagicTextViewUtil;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "-------------";
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = findViewById(R.id.tvTest);
        showText();
        NumberPicker numberPicker = findViewById(R.id.numberPicker);
        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(2);
        numberPicker.setDisplayedValues(new String[]{"aaa", "bbb", "ccc"});
        numberPicker.getValue();
        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                Log.d(TAG, "onValueChange: " + newVal);
            }
        });
    }

    private void showText() {
        MagicTextViewUtil.getInstance(mTextView)
                .append("这是测试")
                .append(R.mipmap.ic_launcher)
                .append("点击这里", getResources().getColor(R.color.colorPrimaryDark), true, new MagicTextViewUtil.OnTextClickListener() {
                    @Override
                    public void onClick(String text) {
                        Toast.makeText(MainActivity.this, "点击成功", Toast.LENGTH_SHORT).show();
                    }
                })
                .append("红色", Color.RED)
                .append("下划线", true)
                .show();
    }
}
