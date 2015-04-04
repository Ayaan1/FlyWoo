package com.zjk.wifiproject.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Random;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.UnderlineSpan;
import android.widget.EditText;

import com.zjk.wifiproject.view.HandyTextView;


/**
 * @fileName TextUtils.java
 * @package szu.wifichat.android.util
 * @description �ı�������
 */
public class TextUtils {
    /**
     * ����»���
     * 
     * @param context
     *            ������
     * @param textView
     *            ����»��ߵ�TextView
     * @param start
     *            ����»��߿�ʼ��λ��
     * @param end
     *            ����»��߽�����λ��
     */
    public static void addUnderlineText(final Context context, final HandyTextView textView,
            final int start, final int end) {
        textView.setFocusable(true);
        textView.setClickable(true);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(textView
                .getText().toString().trim());
        spannableStringBuilder.setSpan(new UnderlineSpan(), start, end,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(spannableStringBuilder);
    }

    /**
     * ��ȡ�����еĹ�������
     * 
     * @param text
     *            �������ŵĹ�������
     * @param defaultText
     *            Ĭ�ϵĹ�������(�ڻ�ȡ����ʱ���ظ�ֵ)
     * @return
     */
    public static String getCountryCodeBracketsInfo(String text, String defaultText) {
        if (text.contains("(") && text.contains(")")) {
            int leftBrackets = text.indexOf("(");
            int rightBrackets = text.lastIndexOf(")");
            if (leftBrackets < rightBrackets) {
                return "+" + text.substring(leftBrackets + 1, rightBrackets);
            }
        }
        if (defaultText != null) {
            return defaultText;
        }
        else {
            return text;
        }
    }

    /**
     * �������ջ�ȡ����
     * 
     * @param month
     *            ��
     * @param day
     *            ��
     * @return
     */
    public static String getConstellation(int month, int day) {
        String[] constellationArr = { "ˮƿ��", "˫����", "������", "��ţ��", "˫����", "��з��", "ʨ����", "��Ů��",
                "�����", "��Ы��", "������", "ħ����" };
        int[] constellationEdgeDay = { 20, 19, 21, 21, 21, 22, 23, 23, 23, 23, 22, 22 };
        if (day < constellationEdgeDay[month]) {
            month = month - 1;
        }
        if (month >= 0) {
            return constellationArr[month];
        }
        // default to return Ħ����
        return constellationArr[11];
    }

    /**
     * ���������ջ�ȡ����
     * 
     * @param year
     *            ��
     * @param month
     *            ��
     * @param day
     *            ��
     * @return
     */
    public static int getAge(int year, int month, int day) {
        int age = 0;
        Calendar calendar = Calendar.getInstance();
        if (calendar.get(Calendar.YEAR) == year) {
            if (calendar.get(Calendar.MONTH) == month) {
                if (calendar.get(Calendar.DAY_OF_MONTH) >= day) {
                    age = calendar.get(Calendar.YEAR) - year + 1;
                }
                else {
                    age = calendar.get(Calendar.YEAR) - year;
                }
            }
            else if (calendar.get(Calendar.MONTH) > month) {
                age = calendar.get(Calendar.YEAR) - year + 1;
            }
            else {
                age = calendar.get(Calendar.YEAR) - year;
            }
        }
        else {
            age = calendar.get(Calendar.YEAR) - year;
        }
        if (age < 0) {
            return 0;
        }
        return age;
    }

    /**
     * �ж��ı���������Ƿ�Ϊ��
     * 
     * @param editText
     *            ��Ҫ�ж��Ƿ�Ϊ�յ�EditText����
     * @return boolean �����Ƿ�Ϊ��,��(true),�ǿ�(false)
     */
    public static boolean isNull(EditText editText) {
        String text = editText.getText().toString().trim();
        if (text != null && text.length() > 0) {
            return false;
        }
        return true;
    }

    /**
     * ����ָ�����ȵ�һ������
     * 
     * @param NumLen ���ִ�λ��
     * @return
     */
    public static String getRandomNumStr(int NumLen) {
        Random random = new Random(System.currentTimeMillis());
        StringBuffer str = new StringBuffer();
        int i, num;
        for (i = 0; i < NumLen; i++) {
            num = random.nextInt(10); // 0-10�������
            str.append(num);
        }
        return str.toString();
    }

    /**
     * ��ȡAssets�е�json�ı�
     * 
     * @param context
     *            ������
     * @param name
     *            �ı�����
     * @return
     */
    public static String getJson(Context context, String name) {
        // TODO �����
        if (name != null) {
            String path = "json/" + name;
            InputStream is = null;
            try {
                is = context.getAssets().open(path);
                return readTextFile(is);
            }
            catch (IOException e) {
                return null;
            }
            finally {
                try {
                    if (is != null) {
                        is.close();
                        is = null;
                    }
                }
                catch (IOException e) {

                }
            }
        }
        return null;
    }

    /**
     * ���������л�ȡ�ı�
     * 
     * @param inputStream
     *            �ı�������
     * @return
     */
    public static String readTextFile(InputStream inputStream) {
        // TODO �����
        String readedStr = "";
        BufferedReader br;
        try {
            br = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            String tmp;
            while ((tmp = br.readLine()) != null) {
                readedStr += tmp;
            }
            br.close();
            inputStream.close();
        }
        catch (UnsupportedEncodingException e) {
            return null;
        }
        catch (IOException e) {
            return null;
        }

        return readedStr;
    }

}
