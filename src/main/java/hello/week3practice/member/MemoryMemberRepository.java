package hello.week3practice.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{
    Map<Long, Member> db = new HashMap<>();
    @Override
    public void save(Member member) {
        db.put(member.getId(), member);
    }

    @Override
    public Member findById(long id) {
        return db.get(id);
    }

    @Override
    public void clear() {
        db.clear();
    }
}
