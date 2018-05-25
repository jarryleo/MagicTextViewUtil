package cn.leo.magictextviewutil.utils;

import android.graphics.Color;
import android.support.annotation.DrawableRes;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Leo on 2018/5/18.
 */

public class MagicTextViewUtil {

    private TextView mTextView;
    private StringBuilder mStringBuilder = new StringBuilder();
    private List<SpannableItem> mSpannableItemList = new ArrayList<>();

    public interface OnTextClickListener {
        void onClick(String text);
    }

    private static class SpannableItem {
        public SpannableItem(Object spannable, int start, int end, int flag) {
            this.spannable = spannable;
            this.start = start;
            this.end = end;
            this.flag = flag;
        }

        private Object spannable;
        private int start;
        private int end;
        private int flag;
    }

    public static MagicTextViewUtil getInstance(TextView textView) {
        return new MagicTextViewUtil(textView);
    }

    private MagicTextViewUtil(TextView textView) {
        mTextView = textView;
    }

    public MagicTextViewUtil append(String text) {
        mStringBuilder.append(text);
        return this;
    }

    public MagicTextViewUtil append(String text, final int color) {
        ForegroundColorSpan spannable = new ForegroundColorSpan(color);
        int start = mStringBuilder.length();
        append(text);
        int end = mStringBuilder.length();
        mSpannableItemList.add(new SpannableItem(
                spannable, start, end,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE));
        return this;
    }

    public MagicTextViewUtil append(String text, final boolean underline) {
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                ds.setUnderlineText(underline);//false去掉下划线
            }
        };
        int start = mStringBuilder.length();
        append(text);
        int end = mStringBuilder.length();
        mSpannableItemList.add(new SpannableItem(
                clickableSpan, start, end,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE));
        return this;
    }

    public MagicTextViewUtil append(final String text, final OnTextClickListener clickListener) {
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                if (clickListener != null) clickListener.onClick(text);
            }
        };
        int start = mStringBuilder.length();
        append(text);
        int end = mStringBuilder.length();
        mSpannableItemList.add(new SpannableItem(
                clickableSpan, start, end,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE));
        return this;
    }

    public MagicTextViewUtil append(String text, final int color, final boolean underline) {
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                ds.setColor(color); //点击文字颜色
                ds.setUnderlineText(underline);//false去掉下划线
            }
        };
        int start = mStringBuilder.length();
        append(text);
        int end = mStringBuilder.length();
        mSpannableItemList.add(new SpannableItem(
                clickableSpan, start, end,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE));
        return this;
    }

    public MagicTextViewUtil append(final String text, final int color, final OnTextClickListener clickListener) {
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                if (clickListener != null) clickListener.onClick(text);
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                ds.setColor(color); //点击文字颜色
            }
        };
        int start = mStringBuilder.length();
        append(text);
        int end = mStringBuilder.length();
        mSpannableItemList.add(new SpannableItem(
                clickableSpan, start, end,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE));
        return this;
    }

    public MagicTextViewUtil append(final String text, final int color, final boolean underline, final OnTextClickListener clickListener) {
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                if (clickListener != null) clickListener.onClick(text);
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                ds.setColor(color); //点击文字颜色
                ds.setUnderlineText(underline);//false去掉下划线
            }
        };
        int start = mStringBuilder.length();
        append(text);
        int end = mStringBuilder.length();
        mSpannableItemList.add(new SpannableItem(
                clickableSpan, start, end,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE));
        return this;
    }

    public MagicTextViewUtil append(final @DrawableRes int resourceId) {
        ImageSpan imageSpan = new ImageSpan(mTextView.getContext(), resourceId);
        int start = mStringBuilder.length();
        append("icon");
        int end = mStringBuilder.length();
        mSpannableItemList.add(new SpannableItem(
                imageSpan, start, end,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE));
        return this;
    }

    public void show() {
        SpannableString spannableString = new SpannableString(mStringBuilder.toString());
        for (SpannableItem spannableItem : mSpannableItemList) {
            spannableString.setSpan(
                    spannableItem.spannable,
                    spannableItem.start,
                    spannableItem.end,
                    spannableItem.flag);
        }
        mTextView.setHighlightColor(Color.TRANSPARENT);//设置选中文字高亮颜色
        mTextView.setText(spannableString);
        mTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }

}
