package com.framework.automation.cucumber.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.config.RequestConfig.Builder;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpUtil {

    //连接池
    private static PoolingHttpClientConnectionManager connectionMgr;
    //超时时间
    private static final int MAX_TIMEOUT = 7000;

    private static RequestConfig requestConfig;
    static{
        //设置连接池
        connectionMgr = new PoolingHttpClientConnectionManager();
        //设置连接池大小
        connectionMgr.setMaxTotal(100);
        connectionMgr.setDefaultMaxPerRoute(connectionMgr.getMaxTotal());

        RequestConfig.Builder configBuilder = RequestConfig.custom();
        //设置连接超时
        configBuilder.setConnectTimeout(MAX_TIMEOUT);
        //设置读取超时
        configBuilder.setSocketTimeout(MAX_TIMEOUT);
        //设置从连接池获取连接实例的超时
        configBuilder.setConnectionRequestTimeout(MAX_TIMEOUT);
        requestConfig = configBuilder.build();

    }


    /**
     *   GET 请求       带输入参数
     * @param Url      请求host地址
     * @param params   参数
     * @return
     */
    public static String httpGet(String Url,Map<String, Object>params)
    {
        //返回结果
        String result = null;
        //拼接url
        StringBuilder builder = new StringBuilder(Url);
        if (Url.contains("?")) {
            builder.append("&");
        }else{
            builder.append("?");
        }
        int i=0;
        for (String key : params.keySet()) {
            if (i != 0 ) {
                builder.append("&");
            }
            builder.append(key);
            builder.append("=");
            builder.append(params.get(key));
            i++;
        }
        String apiUrl = builder.toString();
        System.out.println(apiUrl);

        //创建client
        HttpClient client = HttpClients.createDefault();

        try {
            HttpGet get = new HttpGet(apiUrl);
            HttpResponse response = client.execute(get);
            //获取请求状态码
            int statusCode = response.getStatusLine().getStatusCode();
            //System.out.println(statusCode);

            HttpEntity entity = response.getEntity();
            if (entity != null) {
                result = EntityUtils.toString(entity,"UTF-8");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    /**
     *   POST 请求
     * @param url             请求url
     * @param params          post提交参数
     * @return
     */
    public static String httpPost(String url,Map<String, Object>params)
    {
        HttpClient client = HttpClients.createDefault();
        String result = null;
        try {
            HttpPost post = new HttpPost(url);
            //添加post提交参数
            ArrayList<NameValuePair> pairList = new ArrayList<NameValuePair>();
            for(Map.Entry<String, Object> entry:params.entrySet())
            {
                NameValuePair pair = new BasicNameValuePair(entry.getKey(), entry.getValue().toString());
                pairList.add(pair);
            }

            post.setEntity(new UrlEncodedFormEntity(pairList,"UTF-8"));
            System.out.println(pairList);
            HttpResponse response = client.execute(post);
            //获取状态码
            int statueCode = response.getStatusLine().getStatusCode();
            //System.out.println(statueCode);

            HttpEntity entity = response.getEntity();
            if (entity != null) {
                result = EntityUtils.toString(entity);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}