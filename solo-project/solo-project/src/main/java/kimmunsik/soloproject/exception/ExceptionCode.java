package kimmunsik.soloproject.exception;

import lombok.Getter;

public enum ExceptionCode {
    MEMBER_NOT_FOUND(404, "Member not found"),
    MEMBER_EXISTS(409, "Member exists"),
    REGION_NOT_FOUND(404, "Region not found"),
    REGION_CODE_EXISTS(409, "Region Code exists"),
    INDUSTRY_NOT_FOUND(404, "Industry not found"),
    INDUSTRY_CHANGE_ORDER(403, "Industry can not change"),
    NOT_IMPLEMENTATION(501, "Not Implementation"),
    INVALID_MEMBER_STATUS(400, "Invalid member status");

    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int code, String message) {
        this.status = code;
        this.message = message;
    }
}