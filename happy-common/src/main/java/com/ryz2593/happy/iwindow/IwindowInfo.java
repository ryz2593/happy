package com.ryz2593.happy.iwindow;

import lombok.Data;

@Data
public class IwindowInfo {
    private String styleNo;
    private String styleName;
    private String stylePath;

    public String getStyleNo() {
        return styleNo;
    }

    public void setStyleNo(String styleNo) {
        this.styleNo = styleNo;
    }

    public String getStyleName() {
        return styleName;
    }

    public void setStyleName(String styleName) {
        this.styleName = styleName;
    }

    public String getStylePath() {
        return stylePath;
    }

    public void setStylePath(String stylePath) {
        this.stylePath = stylePath;
    }

    @Override
    public String toString() {
        return "{" +
                "styleNo='" + styleNo + '\'' +
                ", styleName='" + styleName + '\'' +
                ", stylePath='" + stylePath + '\'' +
                '}';
    }


}
