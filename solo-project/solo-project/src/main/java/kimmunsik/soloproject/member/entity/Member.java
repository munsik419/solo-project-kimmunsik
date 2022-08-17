package kimmunsik.soloproject.member.entity;

import kimmunsik.soloproject.audit.Auditable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Member extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    private String region;

    @Column(length = 100, nullable = false, unique = true)
    private String industry;

    @Enumerated(value = EnumType.STRING)
    @Column(length = 20, nullable = false)
    private MemberStatus memberStatus = MemberStatus.MEMBER_ACTIVE;

    public Member(String email) {
        this.name = name;
    }

    public Member(String name, String resion, String industry) {
        this.name = name;
        this.region = resion;
        this.industry = industry;
    }


    public enum MemberStatus {
        MEMBER_ACTIVE("활동중"),
        MEMBER_SLEEP("휴면 상태"),
        MEMBER_QUIT("탈퇴 상태");

        @Getter
        private String status;

        MemberStatus(String status) {
            this.status = status;
        }
    }
}