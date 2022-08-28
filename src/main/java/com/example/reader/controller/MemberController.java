package com.example.reader.controller;

import com.example.reader.entity.Evaluation;
import com.example.reader.entity.Member;
import com.example.reader.entity.MemberReadState;
import com.example.reader.service.EvaluationService;
import com.example.reader.service.MemberService;
import com.example.reader.utils.ResponseUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/member")
public class MemberController {

    @Resource
    MemberService memberService;

    @Resource
    EvaluationService evaluationService;

    @PostMapping("/register")
    public ResponseUtils register(String username, String password, String nickname, String vc, HttpServletRequest request) {
        String verifyCode = (String) request.getSession().getAttribute("kaptchaVerifyCode");
        ResponseUtils resp;
        if (vc == null || !vc.equalsIgnoreCase(verifyCode)) {
            resp = new ResponseUtils("VerifyCodeError", "验证码错误");
        } else {
            try {
                memberService.createMember(username, password, nickname);
                resp = new ResponseUtils();
            } catch (Exception e) {
                e.printStackTrace();
                resp = new ResponseUtils(e.getClass().getSimpleName(), e.getMessage());
            }
        }
        return resp;
    }

    @PostMapping("/login")
    public ResponseUtils checkLogin(String username, String password, String vc, HttpServletRequest request) {
        String verifyCode = (String) request.getSession().getAttribute("kaptchaVerifyCode");
        ResponseUtils resp;
        if (vc == null || !vc.equalsIgnoreCase(verifyCode)) {
            resp = new ResponseUtils("VerifyCodeError", "验证码错误");
        } else {
            try {
                Member member = memberService.checkLogin(username, password);
                member.setPassword(null);
                member.setSalt(null);
                resp = new ResponseUtils().put("member", member);
            } catch (Exception e) {
                e.printStackTrace();
                resp = new ResponseUtils(e.getClass().getSimpleName(), e.getMessage());
            }
        }
        System.out.println(resp);
        return resp;
    }

    @GetMapping("/selectById")
    public ResponseUtils selectById(Long memberId) {
        ResponseUtils resp;
        try {
            Member member = memberService.selectById(memberId);
            resp = new ResponseUtils().put("member", member);
        } catch (Exception e) {
            e.printStackTrace();
            resp = new ResponseUtils(e.getClass().getSimpleName(), e.getMessage());
        }
        return resp;
    }

    @GetMapping("/selectReadState")
    public ResponseUtils selectMemberReadState(Long memberId, Long bookId) {
        ResponseUtils responseUtils;
        try {
            MemberReadState memberReadState = memberService.selectMemberReadState(memberId, bookId);
            responseUtils = new ResponseUtils().put("readState", memberReadState);
        } catch (Exception e) {
            e.printStackTrace();
            responseUtils = new ResponseUtils(e.getClass().getSimpleName(), e.getMessage());
        }
        return responseUtils;
    }

    @PostMapping("/updateReadState")
    public ResponseUtils updateReadState(Long memberId, Long bookId, Integer readState) {
        ResponseUtils responseUtils;
        try {
            MemberReadState memberReadState = memberService.updateMemberReadState(memberId, bookId, readState);
            responseUtils = new ResponseUtils().put("readState", memberReadState);
        } catch (Exception e) {
            e.printStackTrace();
            responseUtils = new ResponseUtils(e.getClass().getSimpleName(), e.getMessage());
        }
        return responseUtils;
    }


    @PostMapping("/evaluate")
    public ResponseUtils evaluate(Long memberId, Long bookId, Integer score, String content) {
        ResponseUtils responseUtils;
        try {
            Evaluation evaluation = evaluationService.evaluate(memberId, bookId, score, content);
            responseUtils = new ResponseUtils().put("evaluation", evaluation);
        } catch (Exception e) {
            e.printStackTrace();
            responseUtils = new ResponseUtils(e.getClass().getSimpleName(), e.getMessage());
        }
        return responseUtils;
    }

    @PostMapping("/enjoy")
    public ResponseUtils enjoy(Long evaluationId) {
        ResponseUtils responseUtils;
        try {
            Evaluation evaluation = evaluationService.enjoy(evaluationId);
            responseUtils = new ResponseUtils().put("evaluation", evaluation);
        } catch (Exception e) {
            e.printStackTrace();
            responseUtils = new ResponseUtils(e.getClass().getSimpleName(), e.getMessage());
        }
        return responseUtils;
    }


}
