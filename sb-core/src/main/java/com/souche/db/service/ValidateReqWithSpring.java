package com.souche.db.service;

import com.souche.db.annotation.Validate;
import org.springframework.stereotype.Service;

@Service("validateReqWithSpring")
public class ValidateReqWithSpring {
    @Validate
    public void validateLength(@Validate(require = true, length = "[10,15]", reg = "^1[3|4|5|8][0-9]\\d{8}$", failMessage = "错啦") String abc,
                               @Validate(require = true, failMessage = "错啦") String aaa,
                               @Validate(failMessage = "错啦", userDefinedMethod = "com.souche.lightning.util.ValidateReq.validateLength") String fds) {
        System.out.println(abc);
        System.out.println(aaa);
        System.out.println(fds);
    }
}
