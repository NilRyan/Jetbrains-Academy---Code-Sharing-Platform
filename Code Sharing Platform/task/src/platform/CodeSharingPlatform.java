package platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import platform.dto.CodeDTO;

import javax.servlet.http.HttpServletResponse;

@SpringBootApplication
@RestController
public class CodeSharingPlatform {

    public static void main(String[] args) {
        SpringApplication.run(CodeSharingPlatform.class, args);
    }

    @GetMapping("/code")
    public String getCode(HttpServletResponse response) {
        response.addHeader("Content-Type", "text/html");
        return "<html>\n" +
                "<head>\n" +
                "    <title>Code</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <pre>\n" +
                "public static void main(String[] args) {\n" +
                "    SpringApplication.run(CodeSharingPlatform.class, args);\n" +
                "}</pre>\n" +
                "</body>\n" +
                "</html>";
    }

    @GetMapping("/api/code")
    public CodeDTO getCodeJSON(HttpServletResponse response) {
        response.addHeader("Content-Type", "application/json");
        return new CodeDTO("public static void main(String[] args) {\n    SpringApplication.run(CodeSharingPlatform.class, args);\n}");
    }

}
