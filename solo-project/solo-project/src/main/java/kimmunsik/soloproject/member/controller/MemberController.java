package kimmunsik.soloproject.member.controller;

import kimmunsik.soloproject.member.entity.Member;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Validated
@RequestMapping("v1/members")

public class MemberController {
        @PostMapping

        //postMember() 메서드 : 회원 정보 등록
        //@RequestHeader를 사용해서 Request의 모든 헤더 정보를 Map으로 전달 받는다
        public ResponseEntity postMember(@RequestHeader Map<String, String> headers,
                                                   @RequestParam("name")String name,
                                                   @RequestParam("region")String region,
                                                   @RequestParam("industry")String industry) {

            for (Map.Entry<String, String> entry : headers.entrySet()){
                System.out.println("key: " + entry.getKey() +
                        ", value: " + entry.getValue());
            }
            //리턴 값을 변경된 ResponseEntity로 대체
            //ResponseEntity 객체를 생성하고 생성자 파라미터로 map과 HttpStatus.CREATED를 반환한다
            //HttpStatus.CREATED 는 201, created를 의미한다
            return new ResponseEntity<>(new Member(name, region, industry), HttpStatus.CREATED);

        }

        @PostMapping


        @GetMapping("/{member-id}")
        //@GetMapping은 클라이언트가 서버에 리소스를 조회할 때 사용하는 애너테이션이다
        //getMember() 메서드는 특정 회원의 정보를 클라이언트 쪽에 제공
        public ResponseEntity getMember(@PathVariable("member-id")long memberId) {

            System.out.println("# memberId: " + memberId);

            //HttpStatus.OK 는 200, OK
            return new ResponseEntity<>(HttpStatus.OK);

        }

        @GetMapping
        //getMembers() 메서드는 회원 목록을 클라이언트에게 제공하는 핸들러 메서드이다
        public ResponseEntity getMembers() {
            System.out.println("# get Members");

            //HttpStatus.OK 는 200, OK
            return new ResponseEntity<>(HttpStatus.OK);

        }
}