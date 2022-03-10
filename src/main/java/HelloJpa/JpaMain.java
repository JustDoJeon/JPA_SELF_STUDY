//package HelloJpa;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
//import javax.persistence.Persistence;
//import java.util.List;
//
//public class JpaMain {
//
//    public static void main(String[] args) {
//
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
//
//        EntityManager em = emf.createEntityManager();
//
//        //JPA의 모든 데이터 변경은 트랜잭션에서 움직여야함 중요! 그러므로 데이터변경은 트랜잭션안에서 실행해야함
//        EntityTransaction tx = em.getTransaction();
//        tx.begin();
//
//        try {
//            Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("member2");
//            member.changeTeam(team); // 양쪽에 값 넣어줌 편의메소드 사용
//            em.persist(member);
//
//
//            em.flush();
//            em.clear();
//
//            Team findTeam = em.find(Team.class, team.getId()); //1차 캐시
//            List<Member> members = findTeam.getMembers();
//
//
//            tx.commit();
//        } catch (Exception e) {
//            tx.rollback();
//        } finally {
//            em.close();
//        }
//        emf.close();
//    }
//}
