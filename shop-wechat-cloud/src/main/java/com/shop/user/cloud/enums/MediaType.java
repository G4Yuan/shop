package com.shop.user.cloud.enums;

public enum MediaType {

	 /**
     * 七牛云
     */
    LOCAL_PAGE(1),
    /**
     * 阿里云
     */
    OTHER_WX_PROGRAM(2),
    /**
     * 腾讯云
     */
    OTHER_APP(3);

    private int value;

    private MediaType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
