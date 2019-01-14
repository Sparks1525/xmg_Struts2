package core.web.config;


//封装<result name="" type="">/资源</result>元素数据
public class ResultConfig {
    private String name;//封装<result/>元素的name属性,表示逻辑视图名称
    private String type;//封装<result/>元素的type属性,表示跳转方式(请求转发/URL重定向)
    private String path;//封装<result/>元素的文本内容,表示真实地跳转到哪一个资源页面中去

    public ResultConfig(String name, String type, String path) {
        this.name = name;
        this.type = type;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getPath() {
        return path;
    }
}
