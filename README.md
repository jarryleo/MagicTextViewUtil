# MagicTextViewUtil
可以同时设置文本框其中某些文字变色，下划线，点击事件等的工具类

```
MagicTextViewUtil.getInstance(mTextView)
                .append("这是测试")
                .append("红色", Color.RED)
                .append("点击这里", Color.CYAN, new MagicTextViewUtil.OnTextClickListener() {
                    @Override
                    public void onClick(String text) {
                        Toast.makeText(MainActivity.this, "点击成功", Toast.LENGTH_SHORT).show();
                    }
                })
                .append("下划线", true)
                .show();
```
