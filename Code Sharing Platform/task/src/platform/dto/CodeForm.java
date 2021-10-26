package platform.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CodeForm {
    private String code;

    public CodeForm(String code) {
        this.code = code;
    }

    public CodeForm() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "CodeDto{" +
                "code='" + code + '\'' +
                '}';
    }
}
