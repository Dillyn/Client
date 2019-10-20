package test_gui.co.za.services.impli;

import test_gui.co.za.domain.members.Member;
import test_gui.co.za.rest.RestAPI;
import test_gui.co.za.rest.impli.MemberRestImpli;
import test_gui.co.za.services.MemberService;

import java.util.List;

public class MemberServiceImpli implements MemberService {
    private  MemberRestImpli rest = new MemberRestImpli();

    @Override
    public Member findById(Integer id) {
      return  rest.get(id);
    }

    @Override
    public Member save(Member entity) {
       return rest.post(entity);
    }

    @Override
    public Member update(Member entity) {
        return rest.put(entity);
    }

    @Override
    public void delete(Integer id) {
        rest.delete(id);
    }

    @Override
    public List<Member> findAll() {
        return rest.getAll();
    }
}
