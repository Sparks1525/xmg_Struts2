package core.web.config;

import java.util.HashMap;
import java.util.Map;

//封装<action name="" class="" method=""/>元素的信息
//每一个<action>元素,都要对应一个ActionConfig对象
public class ActionConfig {
    private String name;//<封装<action/>元素的name属性
    private String className;//封装<action/>的class属性
    private String method;//封装<action/>元素的method属性

    //封装<action/>元素中多个<result/>元素
    private Map<String,ResultConfig> resultMap = new HashMap<>();

    public ActionConfig() {
    }

    public ActionConfig(String name, String className, String method) {
        this.name = name;
        this.className = className;
        this.method = method;
    }

    public String getName() {
        return name;
    }

    public String getClassName() {
        return className;
    }

    public String getMethod() {
        return method;
    }

    public Map<String, ResultConfig> getResultMap() {
        return resultMap;
    }

    public void setResultMap(Map<String, ResultConfig> resultMap) {
        this.resultMap = resultMap;
    }

    @Override
    public String toString() {
        return "ActionConfig{" +
                "name='" + name + '\'' +
                ", className='" + className + '\'' +
                ", method='" + method + '\'' +
                ", resultMap=" + resultMap +
                '}';
    }
}
