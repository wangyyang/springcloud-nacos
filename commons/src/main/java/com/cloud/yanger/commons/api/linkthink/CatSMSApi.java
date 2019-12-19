package com.cloud.yanger.commons.api.linkthink;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CatSMSApi {
    //短信接口URL提交地址
    private static String urlStr = "http://yx.linkthink.cn:8080/sms.aspx";
    private static String userid = "121";
    private static String account = "SportPower18";
    private static String password = "SportPower18";

    /**
     * 发送短信消息
     * @param phones //被叫号码
     * @param info //发送内容
     * @param i //发送内容
     * @param time //有效时间
     * @return Map<String, String>
     */
    public static Map<String, String> sendMsg(String phones, String info,int i,long time) {

        Map<String, String> m = new HashMap<String, String>();
        //任务名称
        String action = "send";
        //返回发送结果
        String state = "";
        String xml = "";
        String content = "";
        if (i == 0) {
            content = "【环球直聘】验证码" + info + "，" + time + "分钟内有效。如非本人操作，请忽略本短信。";
        }
        if (i == 1) {
            content = "【环球直聘】" + info;
        }
        try {
            //传参数
            String parameter = "action=" + action + "&userid=" + userid + "&account=" + account + "&password=" + password + "&mobile=" + phones + "&content=" + content + "&sendTime=&extno=";

            //短信发送开始时间
            Long startt = System.currentTimeMillis();

            //短信URL地址
            URL url = new URL(urlStr);
            URLConnection connection = url.openConnection();
            connection.setDoOutput(true);
            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");

            out.write(parameter);
            out.flush();
            out.close();

            //取得结果集
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((xml = in.readLine()) != null) {
                state = state + xml;
            }
            in.close();
            m = doXMLParse(state);

            //短信发送结束时间
            Long end = System.currentTimeMillis();
            System.out.println("发送 短信 耗时：" + (end - startt));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return m;
    }

    /**
     * 余额及已发送量查询接口
     * @return Map<String, String>
     */
    public static Map<String, String> overage() {

        Map<String, String> m = new HashMap<String, String>();
        //任务名称
        String action = "overage";
        //返回发送结果
        String state = "";
        String xml = "";
        try {
            //传参数
            String parameter = "action="+action+"&userid="+userid+"&account="+account+"&password="+password;

            //短信URL地址
            URL url = new URL(urlStr);
            URLConnection connection = url.openConnection();
            connection.setDoOutput(true);
            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");

            out.write(parameter);
            out.flush();
            out.close();

            //取得结果集
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while((xml=in.readLine()) != null){
                state = state+xml;
            }
            in.close();
            m = doXMLParse(state);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return m;
    }

    /**
     * 随机生成6位随机验证码
     * 方法说明
     * @return String
     */
    public static String createRandomVcode(){
        //验证码
        String vcode = "";
        for (int i = 0; i < 6; i++) {
            vcode = vcode + (int)(Math.random() * 9);
        }
        return vcode;
    }

    public static String urlEnodeUTF8(String str){
        String result = str;
        try {
            result = URLEncoder.encode(str,"UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 解析xml,返回第一级元素键值对。如果第一级元素有子节点，则此节点的值是子节点的xml数据。
     * @param strxml
     * @return
     * @throws JDOMException
     * @throws IOException
     */
    public static Map<String, String> doXMLParse(String strxml) throws Exception {

        if(null == strxml || "".equals(strxml)) {
            return null;
        }

        Map<String, String> m = new HashMap<String, String>();
        InputStream in = String2Inputstream(strxml);

        SAXBuilder builder = new SAXBuilder();
        Document doc = builder.build(new BufferedReader(new InputStreamReader(in, "UTF-8")));
        Element root = doc.getRootElement();
        List<?> list = root.getChildren();
        Iterator<?> it = list.iterator();

        while(it.hasNext()) {
            Element e = (Element) it.next();
            String k = e.getName();
            String v = "";
            List<?> children = e.getChildren();
            if(children.isEmpty()) {
                v = e.getTextNormalize();
            } else {
                v = getChildrenText(children);
            }
            m.put(k, v);
        }

        //关闭流
        in.close();
        return m;
    }

    /**
     * 获取子结点的xml
     * @param children
     * @return String
     */
    public static String getChildrenText(List<?> children) {
        StringBuffer sb = new StringBuffer();
        if(!children.isEmpty()) {
            Iterator<?> it = children.iterator();
            while(it.hasNext()) {
                Element e = (Element) it.next();
                String name = e.getName();
                String value = e.getTextNormalize();
                List<?> list = e.getChildren();
                sb.append("<" + name + ">");
                if(!list.isEmpty()) {
                    sb.append(getChildrenText(list));
                }
                sb.append(value);
                sb.append("</" + name + ">");
            }
        }
        return sb.toString();
    }

    public static InputStream String2Inputstream(String str) {
        return new ByteArrayInputStream(str.getBytes());
    }

    /**
     * 测试
     * 方法说明
     */
    public static void main(String[] args) {

//        Map<String, String> sendMsg = sendMsg("15762250258", "askdjfl",1,0);
//        String returnstatus = sendMsg.get("returnstatus");
//        System.out.println(returnstatus);

		/*try {
			//余额及已发送量查询接口
			Map<String, String> msg = overage();
			System.out.println(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
    }
}
