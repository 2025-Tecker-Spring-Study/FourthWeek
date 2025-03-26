package hello.week3practice.member;


public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }
    @Override
    public void signUp(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(long id) {
        return memberRepository.findById(id);
    }

    @Override
    public void clearDB() {
        memberRepository.clear();
    }
}
