package demo;

import java.util.Objects;

class ResponseInfo {
    public int httpCode;
    public String response;

    public ResponseInfo(int httpCode, String response) {
        this.httpCode = httpCode;
        this.response = response;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseInfo that = (ResponseInfo) o;
        return httpCode == that.httpCode && Objects.equals(response, that.response);
    }

    @Override
    public int hashCode() {
        return Objects.hash(httpCode, response);
    }

    @Override
    public String toString() {
        return "ResponseInfo{" +
                "httpCode=" + httpCode +
                ", response='" + response + '\'' +
                '}';
    }
}
