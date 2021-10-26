package platform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import platform.dto.CodeForm;
import platform.model.CodeEntity;
import platform.repository.CodeRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CodeService {
    private final CodeRepository codeRepository;

    @Autowired
    public CodeService(CodeRepository codeRepository) {
        this.codeRepository = codeRepository;
    }

    /*
       DONE
           1. Change Long ID to UUID
           2. POST /api/code/new should take a JSON object with a field code and two other fields:
                - a. time -> field contains the time (in seconds) during which the snippet is accessible
                - b. views -> field contains a number of views allowed for this snippet
                - 0 and negative values corresponds to absence of the restriction
           3. GET /code/new
                1. <input id="time_restriction" type="text"/> should contain the time restriction.
                2. <input id="views_restriction" type="text"/> should contain the views restriction
       TODO - A
       DONE
            Remember that POST request should contain numbers, not strings.
            GET /api/code/latest and GET /code/latest should not return any restricted snippets.
            GET /api/code/UUID should not be accessible if one of the restrictions is triggered. Return 404 Not Found in this case and all the cases when no snippet with such a UUID was found.
            GET /api/code/UUID should show what restrictions apply to the code piece. Use the keys time and views for that. A zero value (0) should correspond to the absence of the restriction.
            1. time field contains the time (in seconds) during which the snippet is accessible.
            2. views field shows how many additional views are allowed for this snippet (excluding the current one).
       TODO - B
            GET /code/UUID should contain the following elements:
            1.<span id="time_restriction"> ... </span> in case the time restriction is applied.
            2. <span id="views_restriction"> ... </span> in case the views restriction is applied.
            Note: if only one of the restrictions is applied, you should show only one of the above elements.
    */

    public CodeEntity getCodeById(final UUID id) {
        Optional<CodeEntity> code = codeRepository.findById(id);
        if (code.isEmpty() || isRestricted(code.get())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        CodeEntity codeEntity = code.get();
        codeEntity.setViewCount(codeEntity.getViewCount() + 1);

        return codeRepository.save(codeEntity);
    }

    public CodeEntity publishNewCode(final CodeForm newCode) {
        boolean isSecret = newCode.getTime() > 0 || newCode.getViews() > 0 ? true : false;
        CodeEntity codeEntity = new CodeEntity(newCode.getCode(), LocalDateTime.now(), newCode.getTime(), newCode.getViews(), 0L, isSecret);
        return codeRepository.save(codeEntity);
    }

    public List<CodeEntity> getPaginatedAndSortedCode() {
        List<CodeEntity> paginatedAndSortedCode = codeRepository.findByIsSecretFalse(PageRequest.of(0, 10, Sort.by("date").descending())).getContent();
        return paginatedAndSortedCode;
    }

    private boolean isRestricted(CodeEntity code) {
        LocalDateTime dateTimeLimit = code.getDate().plusSeconds(code.getTime());
        final boolean after = LocalDateTime.now().isAfter(dateTimeLimit);
        if (code.getViews() > 0 && code.getViewCount() >= code.getViews() || code.getTime() > 0 && after) {
            return true;
        }
        return false;
    }


}
