package jqpl;

import javax.persistence.*;

public class JPQLMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        //JPA의 모든 데이터 변경은 트랜잭션에서 움직여야함 중요! 그러므로 데이터변경은 트랜잭션안에서 실행해야함
        EntityTransaction tx = em.getTransaction();


        tx.begin();

        try {
            Member member = new Member();
            member.setUsername("도현");
            member.setAge(27);
            em.persist(member);

            //2번째에 타입정보(클래스) 명시
            TypedQuery<Member> query1 = em.createQuery("select m from Member m ", Member.class);

            TypedQuery<String> query2 = em.createQuery("select m.username from Member m", String.class);

            //타입 정보를 받을 수 없음
            Query query3 = em.createQuery("select m.username, m.age from Member m");


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }


}
