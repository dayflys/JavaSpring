package web.webserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import web.webserver.domain.Member;
import web.webserver.service.MemberService;

import java.util.List;

@Controller
public class MemberController {

    private  final MemberService memberService;

    @Autowired //controller와 service를 연결 시켜주는 것
    public MemberController(MemberService memberService) {

        this.memberService = memberService;
        System.out.println("memberService = "+ memberService.getClass());
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        System.out.println("member = "+ member.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
        
    }
}
