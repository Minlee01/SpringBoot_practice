package hello.hellospring.domain;

public class Member {
    private Long id; //id식별자, 시스템이 저장한 임의의 값
    private String name;//이름

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
}
