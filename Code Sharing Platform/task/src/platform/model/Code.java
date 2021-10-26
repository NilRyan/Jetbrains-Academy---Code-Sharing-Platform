package platform.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Code {
    private String code;
    private String date;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    String title;

    public Code() {
    }

    public Code(String code, String date, String title) {
        this.code = code;
        this.date = date;
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
