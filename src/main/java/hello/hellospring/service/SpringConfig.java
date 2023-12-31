package hello.hellospring.service;
import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.*;

import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.Entity;
import javax.sql.DataSource;

import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {

    private final DataSource dataSource;
    private final EntityManager em;

    public SpringConfig(DataSource dataSource, EntityManager em) {
        this.dataSource = dataSource;
        this.em = em;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }


    @Bean
    public MemberRepository memberRepository() {
// return new MemoryMemberRepository();
// return new JdbcMemberRepository(dataSource);
// return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }
}