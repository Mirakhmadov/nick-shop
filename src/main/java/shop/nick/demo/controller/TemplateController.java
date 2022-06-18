package shop.nick.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import shop.nick.demo.payload.CustomResponse;
import shop.nick.demo.payload.ResPageable;
import shop.nick.demo.service.TemplateService;
import shop.nick.demo.utils.AppConstant;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class TemplateController {

    private final TemplateService templateService;

    public TemplateController(TemplateService templateService) {
        this.templateService = templateService;
    }

    @PostMapping("/template")
    public void saveTemplate(MultipartHttpServletRequest request, HttpServletResponse response) throws IOException {
        templateService.saveTemplate(request);

        response.sendRedirect("/admin/index");
    }

    @GetMapping("/template")
    public void getTemplate(Model model, HttpServletResponse response) throws IOException {
        model.addAttribute("templates", templateService.getTemplates());

        response.sendRedirect("/admin/index");
    }
}
