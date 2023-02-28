/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeweb.controllers;

import com.codeweb.pojos.candidate;
import com.codeweb.service.CandidateService;
import com.codeweb.service.JobPostingService;
import java.io.IOException;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author KHOA
 */
@Controller
@ControllerAdvice
public class AccountController {

    @Autowired
    private CandidateService candidateService;

    @Autowired
    private JobPostingService jobPostingService;

    @Autowired
    private JavaMailSender mailSender;

    @ModelAttribute
    public void modelAttribute(Model model,
            @RequestParam(required = false) Map<String, String> params) {
        model.addAttribute("list", this.jobPostingService.getPostByKeyword(params.getOrDefault("keyword", "")));
    }

    @RequestMapping("/LoginController")
    public String login(Model model,
            @RequestParam(value = "code") String code,
            HttpSession session) throws IOException {
        candidate candidate = this.candidateService.getCandidateByCode(code);
        session.setAttribute("user", candidate);
       // sendEmail("toanndse161748@fpt.edu.vn", "toan03182@gmail.com", "Login", "Login Success in Web");
        return "redirect:/";
    }

    @RequestMapping(path = "/LogoutController", method = RequestMethod.GET)
    public String logout(Model model, HttpSession session) {
        if (session != null) {
            session.invalidate();
        }

        return "redirect:/";
    }

    @GetMapping("/account")
    public String account(Model model, HttpSession session) {
        return "account-information";
    }
    // GUI MAIL TINH
    public void sendEmail(String from, String to, String subject, String content) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(from);
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(content);

        mailSender.send(mailMessage);
    }
}
