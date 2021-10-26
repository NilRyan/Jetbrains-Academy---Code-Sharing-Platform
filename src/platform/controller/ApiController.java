package platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import platform.dto.CodeForm;
import platform.dto.CodeResponse;
import platform.model.CodeEntity;
import platform.service.CodeService;
import platform.util.CodeMapper;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/code")
public class ApiController {

    private CodeService codeService;

    @Autowired
    public ApiController(CodeService codeService) {
        this.codeService = codeService;
    }

    @GetMapping("/{id}")
    public CodeResponse getCodeById(@PathVariable UUID id) {

        CodeEntity code = codeService.getCodeById(id);
        long viewsLeft = Math.max(0, code.getViews() - code.getViewCount());
        long timePassed = ChronoUnit.SECONDS.between(code.getDate(), LocalDateTime.now());
        long timeLeft = timePassed > 0 && code.getTime() - timePassed > 0 ? code.getTime() - timePassed : 0;
        return CodeMapper.toCodeResponse(code, viewsLeft, timeLeft);

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
