package com.RealLis.web.redirect.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectController {
    @GetMapping("/redirect")
    public String redirect(String herf
//                           HttpServletResponse response,
//                           HttpServletRequest request
    ) {
       // request.getRequestDispatcher(herf).forward((ServletRequest) request,(ServletResponse) response);
        return"redirect:"+herf;
    }
}
