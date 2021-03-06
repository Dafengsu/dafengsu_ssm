package com.dafengsu.ssm.controller;

import com.dafengsu.ssm.domain.SysLog;
import com.dafengsu.ssm.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author su
 * @description
 * @date 2020/4/3
 */
@Controller
@RequestMapping("/sysLog")
public class SysLogController {
    @Autowired
    private SysLogService sysLogService;
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<SysLog> sysLogs = sysLogService.findAll();
        mv.addObject("sysLogs", sysLogs);
        mv.setViewName("syslog-list");
        return mv;
    }
}
