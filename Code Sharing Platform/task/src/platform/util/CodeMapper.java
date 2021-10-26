package platform.util;

import platform.dto.CodeResponse;
import platform.model.CodeEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CodeMapper {
    public static List<CodeResponse> toListCodeResponse(List<CodeEntity> codeEntityList) {
        List<CodeResponse> responseList = new ArrayList<>();
        for (CodeEntity code : codeEntityList) {
            responseList.add(new CodeResponse(code.getCode(), CurrentDateTime.getString(code.getDate()), 0, 0));
        }
        return responseList;
    }
    public static CodeResponse toCodeResponse(CodeEntity codeEntity, long viewsLeft, long timeLeft) {
        String string = CurrentDateTime.getString(codeEntity.getDate());
        String code = codeEntity.getCode();
        return new CodeResponse(code, string, timeLeft, viewsLeft);
    }
}
