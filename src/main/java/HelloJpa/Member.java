//package HelloJpa;
//
//import javax.persistence.*;
//import java.util.Date;
//
//@Entity
//public class Member {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "MEMBER_ID")
//    private Long id;
//    @Column(name = "USERNAME")
//    private String username;
//    private int age;
//
//    @ManyToOne
//    @JoinColumn(name = "TEAM_ID")
//    private Team team;
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public Team getTeam() {
//        return team;
//    }
//
//    public void setTeam(Team team) {
//        this.team = team;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public void changeTeam(Team team){
//        this.team = team;
//        team.getMembers().add(this);
//    }
//}
