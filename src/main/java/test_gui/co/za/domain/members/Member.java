package test_gui.co.za.domain.members;

public class Member {
    Integer id;
    String firstName;
    String lastName;

    public Member() {
    }

    public Member(Integer id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Member{" +
                "MemberId='" + id + "\n" +
                ", MemberName='" + firstName + "\n" +
                ", MemberLastName='" + lastName + "\n" +
                '}';
    }

}
