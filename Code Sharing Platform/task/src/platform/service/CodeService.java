package platform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;
import platform.dto.CodeForm;
import platform.model.CodeEntity;
import platform.repository.CodeRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CodeService {
    private final CodeRepository codeRepository;

    @Autowired
    public CodeService(CodeRepository codeRepository) {
        this.codeRepository = codeRepository;
    }

    /*
       TODO
           1. get code by id
           2. publish new code
           3. get 10 latest code
    */

    public CodeEntity getCodeById(final Long id) {
        Optional<CodeEntity> code = codeRepository.findById(id);
        if (code.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return code.get();
    }

    public CodeEntity publishNewCode(final CodeForm newCode) {
        return codeRepository.save(new CodeEntity(newCode.getCode(), LocalDateTime.now()));
    }

    public List<CodeEntity> getPaginatedAndSortedCode() {
        List<CodeEntity> paginatedAndSortedCode = codeRepository.findAll(PageRequest.of(0, 10, Sort.by("id").descending())).getContent();
        return paginatedAndSortedCode;
    }


}
