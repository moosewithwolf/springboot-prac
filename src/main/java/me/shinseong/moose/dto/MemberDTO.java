package me.shinseong.moose.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
//@ToString

public class MemberDTO {
    private String name;
    private String email;
    private String organization;

    @Override
    public String toString() {
        return "MemberDTO 데이터 { \n" +
                " name:'" + name + '\'' + ",\n" +
                " email: '" + email + '\'' + ",\n" +
                " organization: '" + organization + '\'' + ",\n" +
                '}';
    }
}
