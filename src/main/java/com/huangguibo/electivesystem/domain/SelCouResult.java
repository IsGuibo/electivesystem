package com.huangguibo.electivesystem.domain;

import java.util.List;

public class SelCouResult {
    private List<String> success;
    private List<String> fail;

    public List<String> getSuccess() {
        return success;
    }

    public void setSuccess(List<String> success) {
        this.success = success;
    }

    public List<String> getFail() {
        return fail;
    }

    public void setFail(List<String> fail) {
        this.fail = fail;
    }
}
