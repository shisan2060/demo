package com.jy.demo.controller;

import com.google.common.collect.Maps;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.URLDecoder;
import java.util.*;

/**
 * SteamController
 *
 * @author shisan
 * @create 2017-11-01 下午5:47
 **/
@Controller
@RequestMapping("/steamController")
public class SteamController {
    //Steam使用openid登录的网址
    final static String STEAM_LOGIN = "https://steamcommunity.com/openid/login";

    /**
     * 组装steam登录url
     *
     * @param returnTo 回调url
     * @author shisan
     * @date 2017/11/1 下午5:49
     */
    public static String getUrl(String returnTo) {
        Map<String, String> params = new HashMap<>();
        params.put("openid.ns", "http://specs.openid.net/auth/2.0");
        params.put("openid.mode", "checkid_setup");
        //登陆成功后要返回url，值得一说的是这个url是可以携带参数的
        params.put("openid.return_to", returnTo);
        //realm的中文解释是领域与范围，我想大概就是你网站域名，授权用户登录你域名下的应用，我这里默认就用传过来的returnTo了
        params.put("openid.realm", returnTo);
        params.put("openid.identity", "http://specs.openid.net/auth/2.0/identifier_select");
        params.put("openid.claimed_id", "http://specs.openid.net/auth/2.0/identifier_select");
        return STEAM_LOGIN + "?" + getUrlParamsByMap(params);
    }

    /**
     * 将map转换成字符串（用&分割）
     *
     * @param null
     * @author shisan
     * @date 2017/11/1 下午5:55
     */
    private static String getUrlParamsByMap(Map<String, String> params) {
        String paramStr = "";
        if (params == null || params.isEmpty()) {
            return paramStr;
        }

        for (String key : params.keySet()) {
            paramStr += key + "=" + params.get(key) + "&";
        }
        return paramStr.substring(0, paramStr.length() - 1);
    }

    /**
     * 将url中传递参数转化为map 其中值进行encode
     *
     * @param param 参数
     * @author shisan
     * @date 2017/11/1 下午5:49
     */
    public static Map<String, String> getUrlParams(String param) throws UnsupportedEncodingException {
        Map<String, String> map = new HashMap<>(0);
        if (StringUtils.isBlank(param)) {
            return map;
        }
        String[] params = param.split("&");
        for (int i = 0; i < params.length; i++) {
            String[] p = params[i].split("=");
            if (p.length == 2) {
                map.put(p[0], URLDecoder.decode(p[1], "UTF-8"));
            }
        }
        return map;
    }

    @RequestMapping("/receiptParams")
    @ResponseBody
    public String receiptParams(HttpServletRequest request) {
        Map<String, String> paramsMap = Maps.newHashMap();
        Enumeration enu = request.getParameterNames();
        while (enu.hasMoreElements()) {
            String paraName = (String) enu.nextElement();
            System.out.println(paraName + ": " + request.getParameter(paraName));
            paramsMap.put(paraName, request.getParameter(paraName));
        }
        try {
            return validate(paramsMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }


    public static String validate(Map<String, String> request) throws ClientProtocolException, IOException {
        //openid.signed这里面的参数用是“，”号隔开的，是提示你返回了哪些参数
        Object signed = request.get("openid.signed");
        //如果没有openid.signed，那肯定这个请求是不正确的直接跳出即可
        if (signed == null || "".equals(signed)) {
            return "";
        }
        //此处开始构造HttpClient对象，配置参数，设置访问方法，获取返回值等，进行一次完整访问
        HttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost(STEAM_LOGIN + "?" + getUrlParamsByMap(request));
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();

        String[] signeds = signed.toString().split(",");
        for (int i = 0; i < signeds.length; i++) {
            String val = request.get("openid." + signeds[i]);
            nvps.add(new BasicNameValuePair("openid." + signeds[i], val == null ? "" : val));
        }
        nvps.add(new BasicNameValuePair("openid.mode", "check_authentication"));
        httppost.setEntity(new UrlEncodedFormEntity(nvps));
        HttpResponse response = httpclient.execute(httppost);
        HttpEntity entity = response.getEntity();
        if (entity == null) {
            return "";
        }
        InputStream instreams = entity.getContent();
        String result = convertStreamToString(instreams);
        //System.out.println("Do something");
        System.out.println(result);
        // Do not need the rest
        httppost.abort();
        //此处是为了将steamid截取出来
        String steamid = "";
        steamid = request.get("openid.claimed_id");
        steamid = steamid.replace("http://steamcommunity.com/openid/id/", "");
        System.out.println("steamid = " + steamid);
        System.out.println("是否授权成功 = " + result.contains("is_valid:true"));
        //虽然steamid能从上一次请求参数中截取出来，我们还是要判断HttpClient返回来的消息是否授权了，判断方式是看字符串中是否含有“is_valid:true”，有就是授权成功了，如果没有，就是“is_valid:false”。
        if (!result.contains("is_valid:true")) {
            return "";
        }
        return steamid;
    }

    public static String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "/n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return sb.toString();

    }


    public static void main(String[] args) {
        System.out.println(getUrl("http://172.16.2.122:8080/steamController/receiptParams"));
    }
}
