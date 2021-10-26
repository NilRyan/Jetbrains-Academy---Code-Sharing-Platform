package platform.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import platform.model.Code;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {
    private final String titleData = "Code";
    List<Code> codeList = new ArrayList<>();


    /*
        TODO
        DONE
            1. Implement individual snippet GET /code/N
                - should return HTML that contains the N-th uploaded code snippet
            2. Implement individual snippet GET /api/code/N
                - should return JSON with N-th uploaded code snippet
            3. Store in memory / list

     */

    @GetMapping(path = "/code/{id}", produces = "text/html")
    public String getCode(@PathVariable String id, Model model) {
        Code code = codeList.get(Integer.parseInt(id));
        model.addAttribute("codeWithId", code);
        return "code";
    }

    @GetMapping(path = "/api/code/{id}", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Code getCodeJSON(@PathVariable String id) {
        return codeList.get(Integer.parseInt(id));
    }
    @GetMapping(path= "/code/new", produces = "text/html")
    public String getCodeNew() {
        return "new";
    }
    @GetMapping(path= "/code/latest", produces = "text/html")
    public String getCodeNew(Model model) {
        int codeListSize = codeList.size();
        List<Code> latest = codeListSize > 10 ? codeList.subList(codeListSize - 10, codeListSize) : codeList;
        model.addAttribute("latestList", latest);
        return "latest";
    }
    @PostMapping(path = "/api/code/new", produces = "application/json;charset=UTF-8" )
    @ResponseBody
    public String setApiCode(@RequestBody Code reCode) {
        Code code = new Code();
        code.setCode(reCode.getCode());
        code.setTitle("Code");
        code.setDate(getCurrentDateTime());
        codeList.add(code);
        return "{ \"id\" : \"" + codeList.indexOf(code) + "\" }";
    }

    @GetMapping(path = "/api/code/latest", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Code> getCodeJSONLatest() {
        int codeListSize = codeList.size();
        List<Code> result = new ArrayList<>(codeList);
        List<Code> responseCode = new ArrayList<>();
        for (int i = result.size() - 1; i >= 0; i--) {
            Code eachCode = codeList.get(i);
            responseCode.add(eachCode);
        }

        if (codeListSize > 10) {
            responseCode = responseCode.subList(0, 10);
        }

        return responseCode;
    }
    public String getCurrentDateTime() {
        LocalDateTime today = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return today.format(formatter);
    }

}
