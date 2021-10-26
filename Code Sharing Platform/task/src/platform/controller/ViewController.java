package platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import platform.dto.CodeResponse;
import platform.model.CodeEntity;
import platform.service.CodeService;
import platform.util.CodeMapper;
import platform.util.CurrentDateTime;

import java.util.List;

@Controller
@RequestMapping(path = "/code", produces = "text/html")
public class ViewController {

    private CodeService codeService;

    @Autowired
    public ViewController(CodeService codeService) {
        this.codeService = codeService;
    }

    @GetMapping("/{id}")
    public String getCode(@PathVariable String id, Model model) {
        CodeEntity code = codeService.getCodeById(Long.parseLong(id));
        CodeResponse codeResponse = CodeMapper.toCodeResponse(code);
        model.addAttribute("codeWithId", codeResponse);
        return "code";
    }

    @GetMapping("/new")
    public String getCodeNew() {
        return "new";
    }
    @GetMapping("/latest")
    public String getLatestCode(Model model) {
        List<CodeEntity> latest = codeService.getPaginatedAndSortedCode();
        List<CodeResponse> codeResponseList = CodeMapper.toListCodeResponse(latest);
        model.addAttribute("latestList", codeResponseList);
        return "latest";
    }

}
