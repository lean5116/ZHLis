package com.RealLis.common.utils;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebServiceUtil {
    private static final Logger logger = LoggerFactory.getLogger(WebServiceUtil.class);
    public  static Object[] commonWsService(String wsdlUrl ,String s,Object... param){
        // 创建动态客户端
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient(wsdlUrl);
        HTTPConduit conduit = (HTTPConduit) client.getConduit();
        HTTPClientPolicy policy = new HTTPClientPolicy();
        policy.setConnectionTimeout(10000);
        policy.setReceiveTimeout(30000);
        conduit.setClient(policy);
        // 需要密码的情况需要加上用户名和密码
        // client.getOutInterceptors().add(new ClientLoginInterceptor(USER_NAME, PASS_WORD));
        Object[] objects = new Object[0];
        try {
            // invoke("方法名",参数1,参数2,参数3....);
            objects = client.invoke(s, param);
            System.out.println("返回数据:" + objects[0]);
        } catch (Exception e) {
            System.out.println(e);
            if(e instanceof javax.xml.ws.WebServiceException){
                logger.error("接口连接超时A");
                if(e.toString().indexOf("Could not send Message")>0){
                    logger.error("接收数据超时B");
                }
            }
            //e.printStackTrace();
        }
        return  objects;
    }
}
