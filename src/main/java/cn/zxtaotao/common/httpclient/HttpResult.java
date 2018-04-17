package cn.zxtaotao.common.httpclient;

/**
 * 封装post请求的响应码和响应体
 * @author zengkang
 *
 */
public class HttpResult {
    private Integer code;//响应码

    private String body;//响应体

    public HttpResult() {
    }

    public HttpResult(Integer code, String body) {
        this.code = code;
        this.body = body;
    }

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getBody() {
        return this.body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
