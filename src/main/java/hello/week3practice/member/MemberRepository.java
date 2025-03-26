package hello.week3practice.member;

public interface MemberRepository {
    void save(Member member);
    Member findById(long id);
    void clear();
}