package core.web.filter;

import core.web.ActionContext;
import core.web.config.ActionConfig;
import core.web.config.ResultConfig;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ActionFilter implements Filter {

    private Map<String, ActionConfig> actionConfigMap = new HashMap<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Document doc = getDocument();
        NodeList nodeList = doc.getElementsByTagName("action");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element actionEl = (Element) nodeList.item(i);
            String actionName = actionEl.getAttribute("name");
            String actionClass = actionEl.getAttribute("class");
            String actionMethod = actionEl.getAttribute("method");

            ActionConfig actionConfig = new ActionConfig(actionName,
                    actionClass, actionMethod);
            actionConfigMap.put(actionName, actionConfig);
            // -----------------------------------
            // 解析result元素
            NodeList resultList = actionEl.getElementsByTagName("result");
            Map<String, ResultConfig> resultMap = new HashMap<>();
            for(int j = 0; j <resultList.getLength();j++){
                Element resultEl = (Element)resultList.item(j);
                String resultName = resultEl.getAttribute("name");
                String resultType = resultEl.getAttribute("type");
                String resultPath = resultEl.getTextContent();
                ResultConfig resultConfig = new ResultConfig(resultName,resultType,resultPath);

                resultMap.put(resultName,resultConfig);
            }
            actionConfig.setResultMap(resultMap);
        }
    }

    private Document getDocument() {
        try {
            InputStream in = Thread.currentThread()
                    .getContextClassLoader()
                    .getResourceAsStream("actions.xml");
            return DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder().parse(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new RuntimeException("从classpath路径加载actions.xml文件失败！");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        //获取请求资源的名称
        ActionContext actionContext = new ActionContext(req,resp);
        ActionContext.setContext(actionContext);
        String requestUri = req.getRequestURI().substring(1);
        //根据不同的请求资源做不同的分发操作
        try {
            if (!actionConfigMap.containsKey(requestUri)) {
                chain.doFilter(req, resp);
            } else {
                ActionConfig actionConfig = actionConfigMap.get(requestUri);
                Class actionClass = Class.forName(actionConfig.getClassName());
                //创建Action对象
                Object actionObject = actionClass.newInstance();
                //调用配置的Action方法,并返回逻辑视图名称
                Method actionMethod = actionClass.getMethod(actionConfig
                        .getMethod());
                String viewName = (String)actionMethod.invoke(actionObject);
                //获取当前逻辑视图对应的<result/>元素的对象
                ResultConfig resultConfig = actionConfig.getResultMap().get(viewName);
                String resultType = resultConfig.getType();//跳转方式
                String resultPath = resultConfig.getPath();//物理视图

                if("dispatcher".equals(resultType)){
                    req.getRequestDispatcher(resultPath).forward(req,resp);
                } else if("redirect".equals(resultType)){
                    resp.sendRedirect(resultPath);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    @Override
    public void destroy() {

    }


}
