package com.yunyou.xemceappendix.controller.file;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ComponentScan
@Controller
public class QueryController {
    @RequestMapping("upload")
    public ModelAndView uploadfile(String filepath) {
        return new ModelAndView("index");
    }
}
