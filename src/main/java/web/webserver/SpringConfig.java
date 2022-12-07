package web.webserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import web.webserver.AOP.TimeTraceAop;
import web.webserver.repository.MemberRepository;
import web.webserver.service.MemberService;

public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService(){ return new MemberService(memberRepository);}

    @Bean
    public TimeTraceAop timeTraceAOP(){
        return new TimeTraceAop();
    }

//    @Bean
//    public MemberRepository memberRepository(){
////        return new JpaMemberRepository(em);
//
//    }
}
