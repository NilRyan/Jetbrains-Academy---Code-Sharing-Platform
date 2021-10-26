package platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import platform.dto.CodeForm;
import platform.dto.CodeResponse;
import platform.model.CodeEntity;
import platform.service.CodeService;
import platform.util.CodeMapper;

import java.util.List;

@RestController
@RequestMapping(path = "/api/code")
public class ApiController {

    private CodeService codeService;

    @Autowired
    public ApiController(CodeService codeService) {
        this.codeService = codeService;
    }

    @GetMapping("/{id}")
    public CodeResponse getCodeById(@PathVariable String id) {
        CodeEntity codeById = codeService.getCodeById(Long.parseLong(id));
        return CodeMapper.toCodeResponse(codeById);
    }

    @PostMapping(path = "/new", produces = "application/json")
    public String publishNewCode(@RequestBody CodeForm newCode) {
        CodeEntity code = codeService.publishNewCode(newCode);
        return "{ \"id\" : \"" + code.getId() + "\" }";
    }
    @GetMapping("/latest")
    public List<CodeResponse> getCodeJSONLatest() {
        List<CodeEntity> codeEntityList = codeService.getPaginatedAndSortedCode();
        List<CodeResponse> response = CodeMapper.toListCodeResponse(codeEntityList);
        return response;
    }
}
