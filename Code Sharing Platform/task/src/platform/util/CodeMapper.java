package platform.util;

import platform.dto.CodeResponse;
import platform.model.CodeEntity;

import java.util.ArrayList;
import java.util.List;

public class CodeMapper {
    public static List<CodeResponse> toListCodeResponse(List<CodeEntity> codeEntityList) {
        List<CodeResponse> responseList = new ArrayList<>();
        for (CodeEntity code : codeEntityList) {
            responseList.add(new CodeResponse(code.getCode(), CurrentDateTime.getString(code.getDate())));
        }
        return responseList;
    }
    public static CodeResponse toCodeResponse(CodeEntity codeEntity) {
        CodeResponse response = new CodeResponse(codeEntity.getCode(), CurrentDateTime.getString(codeEntity.getDate()));
        return response;
    }
}
