package dev.be.moduleapi.service;

import dev.be.modulecommon.domain.Member;
import dev.be.modulecommon.repositories.MemberRepository;
import dev.be.modulecommon.service.CommonDemoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DemoService {

    private final CommonDemoService commonDemoService;

    private final MemberRepository memberRepository;

    public String save() {
        memberRepository.save(Member.builder()
                        .name(Thread.currentThread().getName())
                        .build());
        return "save";
    }

    public String find() {
        int size = memberRepository.findAll().size();
        log.info("DB size : {}", size);
        return "find";
    }

    public String exception() {
        return "exception";
    }

}
