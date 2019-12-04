package com.ryz2593.happy.iwindow;

import lombok.Data;

@Data
public class IwindowInfo {
    private String styleNo;
    private String styleName;
    private String stylePath;

    @Override
    public String toString() {
        return "{" +
                "styleNo='" + styleNo + '\'' +
                ", styleName='" + styleName + '\'' +
                ", stylePath='" + stylePath + '\'' +
                '}';
    }
}
