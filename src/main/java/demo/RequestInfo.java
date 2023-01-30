package demo;

import java.util.Map;
import java.util.Objects;

public class RequestInfo {
    public String url;
    public Map<String, Object> queryStrings;

    public RequestInfo(String url, Map<String, Object> queryStrings) {
        this.url = url;
        this.queryStrings = queryStrings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestInfo that = (RequestInfo) o;
        return Objects.equals(url, that.url) && Objects.equals(queryStrings, that.queryStrings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, queryStrings);
    }

    @Override
    public String toString() {
        return "RequestInfo{" +
                "url='" + url + '\'' +
                ", queryStrings=" + queryStrings +
                '}';
    }
}
