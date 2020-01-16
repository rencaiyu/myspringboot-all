package com.rcy.enums;

public enum SortTypeEnum {

    /** 降序 */
    DESC("1", "降序"),
    /** 升序 */
    ASC("2", "升序")
    ;

    /** 状态码 */
    private String code;

    /** 状态描述 */
    private String description;

    private SortTypeEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
