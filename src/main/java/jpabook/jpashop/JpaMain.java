package jpabook.jpashop;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        //JPA의 모든 데이터 변경은 트랜잭션에서 움직여야함 중요! 그러므로 데이터변경은 트랜잭션안에서 실행해야함
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            //주문한 멤버를 찾을때
            Order order = em.find(Order.class, 1L);
            Long memberId = order.getMemberId();
            Member member = em.find(Member.class, memberId);

            //    private Member member;
            //
            //    public Member getMember() {
            //        return member;
            //    } 를 Order에 추가하면

            Member findMember = order.getMember(); //이렇게 표현가능

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
