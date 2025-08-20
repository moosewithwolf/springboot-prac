package me.shinseong.moose.controller;

import me.shinseong.moose.dto.MemberDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/put-api")
public class PutController {

    @PutMapping(value = "/default")
    public String putMethod() {
        return "This is for the PUT default method";
    }

    @PutMapping(value = "/member")
    public String putMember(@RequestBody Map<String, Object> putData) {
        StringBuilder sb = new StringBuilder();

        putData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });
        return sb.toString();
    }

    @PutMapping(value = "/member1")
    public String putMemberDto1(@RequestBody MemberDTO memberDTO) {
        return memberDTO.toString();
    }

    @PutMapping(value = "/member2")
    public String putMemberDto2(@RequestBody MemberDTO memberDTO) {
        return memberDTO.toString();
    }

    @PutMapping(value = "/member3")
    public ResponseEntity<MemberDTO> putMemberDto3(@RequestBody MemberDTO memberDTO) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(memberDTO);
    }

    @PutMapping(value = "/member4")
    public ResponseEntity<MemberDTO> putMemberDto4(@RequestBody MemberDTO memberDTO) {
        return ResponseEntity.ok(memberDTO);
    }

    @PutMapping("/member5")
    public MemberDTO putMemberDto5(@RequestBody MemberDTO memberDTO) {
        return memberDTO;  // Jackson이 자동으로 JSON으로 직렬화
    }
}
