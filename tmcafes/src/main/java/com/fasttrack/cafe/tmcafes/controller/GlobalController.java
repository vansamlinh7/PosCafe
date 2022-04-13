package com.fasttrack.cafe.tmcafes.controller;

import com.fasttrack.cafe.tmcafes.model.CurrentUser;
import com.fasttrack.cafe.tmcafes.untils.UsernameNotfoundExceiption;
import com.fasttrack.cafe.tmcafes.untils.Utils;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;


@ControllerAdvice
public class GlobalController {



    @ModelAttribute("currentUser")
    public CurrentUser getCurrentUser(Authentication authentication) {
        CurrentUser currentUser = null;
        if (authentication != null)
            currentUser = (CurrentUser) authentication.getPrincipal();
        return currentUser;
    }

    @ModelAttribute("utils")
    public Utils getUtils() {
        return new Utils();
    }

    @ExceptionHandler(UsernameNotfoundExceiption.class)
    public ModelAndView handleCategoryNotFoundException() {

        ModelAndView mav = new ModelAndView();
        mav.setViewName("test");
        mav.setStatus(HttpStatus.NOT_FOUND);
        return mav;
    }
}
