package hello.week3practice.member;

public interface MemberService {
    void signUp(Member member);
    Member findMember(long id);
    void clearDB();
}
