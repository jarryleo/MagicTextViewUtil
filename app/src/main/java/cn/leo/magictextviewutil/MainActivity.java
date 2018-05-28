package cn.leo.magictextviewutil;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import cn.leo.magictextviewutil.utils.MagicTextViewUtil;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = findViewById(R.id.tvTest);
        showText();
    }

    private void showText() {
        MagicTextViewUtil.getInstance(mTextView)
                .append("这是测试")
                .append(R.mipmap.ic_launcher)
                .append("红色", Color.RED)
                .append("点击这里", getResources().getColor(R.color.colorPrimaryDark), true, new MagicTextViewUtil.OnTextClickListener() {
                    @Override
                    public void onClick(String text) {
                        Toast.makeText(MainActivity.this, "点击成功", Toast.LENGTH_SHORT).show();
                    }
                })
                .append("下划线", true)
                .show();
    }
}
