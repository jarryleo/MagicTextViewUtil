package cn.leo.magictextviewutil;

import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        //assertEquals(4, 2 + 2);
        String s = "android 如何用正则表达式去除字符串中[]及其包含的内容。" +
                "比如：[k3]白日依山尽[k0]的作者是王之涣 把[k3][k0]去掉";
        String r = s.replaceAll("\\[.*?\\]","");
        System.out.println(r);
    }
}