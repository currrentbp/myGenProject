package com.bp.util.all;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

/**
 * Created by issuser on 2017/5/25.
 */
public class StringUtilTest {
    @Test
    public void deleteLast() throws Exception {

    }

    @Test
    public void getStringWithOutSome() throws Exception {

    }

    @Test
    public void getStringWithOutSome1() throws Exception {

    }

    @Test
    public void getStringWithOutSome2() throws Exception {

    }

    @Test
    public void fillBySome() throws Exception {

    }

    @Test
    public void fillBySome1() throws Exception {

    }

    @Test
    public void fillBySome2() throws Exception {

    }

    @Test
    public void fillBySome3() throws Exception {

    }

    @Test
    public void getCaptureName() throws Exception {

    }

    @Test
    public void getSplitString() throws Exception {

    }

    @Test
    public void insertSomethingToWhere() throws Exception {

    }

    @Test
    public void stringToList() throws Exception {

    }

    @Test
    public void stringToList1() throws Exception {

    }

    @Test
    public void letter2Int() throws Exception {

    }

    @Test
    public void int2Letter() throws Exception {

    }

    @Test
    public void getALabel() throws Exception {
        String source = "<tr> \\n <td><a href=\\\"http://baidu.lecai.com/lottery/draw/view/1?phase=17059\\\"" +
                " target=\\\"_blank\\\">17059</a></td> \\n <td>2017-05-24（三）</td> \\n <td class=\\\"balls\\\">" +
                " \\n  <table width=\\\"100%\\\"> \\n   <tbody>\\n    <tr> \\n     <td class=\\\"redBalls\\\">" +
                " <em>08</em><em>11</em><em>13</em><em>15</em><em>17</em> </td> \\n     <td class=\\\"blueBalls\\\">" +
                " <em>03</em> <em>10</em> </td> \\n    </tr> \\n   </tbody>\\n  </table> </td> \\n <td> \\n " +
                " <table width=\\\"100%\\\"> \\n   <tbody>\\n    <tr> \\n     <td class=\\\"NotNumber\\\">1</td> \\n  " +
                "   <td class=\\\"cash\\\">15000000</td> \\n    </tr> \\n   </tbody>\\n  </table> </td> \\n <td> \\n " +
                " <table width=\\\"100%\\\"> \\n   <tbody>\\n    <tr>\\n     <td class=\\\"NotNumber\\\">116</td> \\n    " +
                " <td class=\\\"cash\\\">85050</td> \\n    </tr>\\n   </tbody>\\n  </table> </td> \\n</tr>"
                + "<a/>";
        System.out.println(StringUtil.getLabel(source, "em"));
    }


}