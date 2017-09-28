package com.souche.test.validate;


import com.souche.db.annotation.Validate;

public class ValidateReq {
    public void validateLength(@Validate(require = true, length = "[10,15]", reg = "^1[3|4|5|8][0-9]\\d{8}$", failMessage = "错啦") String abc,
                               @Validate(require = true, failMessage = "错啦") String aaa,
                               @Validate(failMessage = "错啦", userDefinedMethod = "com.souche.lightning.util.ValidateReq.validateLength") String fds) {
    }

    public boolean validateLength(String fds) {
        if ("att".equals(fds))
            return true;
        else return false;
    }


}
