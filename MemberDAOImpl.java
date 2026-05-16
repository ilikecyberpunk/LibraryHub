import java.util.*;
import java.sql.*;

public class MemberDAOImpl implements MemberDAO {
    public void addMember(Member member){
        Connection con = DBConnection.getConnection();
        PreparedStatement st = null;

        String sql = "INSERT INTO MEMBER(MEMBER_ID, NAME, PHONE) VALUES(MEMBER_SEQ.NEXTVAL, ?, ?)";
        try{
            st = con.prepareStatement(sql);
            st.setString(1, member.getName());
            st.setString(2, member.getPhone());
            st.executeUpdate();
            System.out.println("멤버 추가 완료 : " + member.getName());
        }
        catch(Exception e){
            System.out.println(e);
        }
        finally{
            DBConnection.close(con, st, null);
        }
    }

    public Member findById(int memberId){
        Connection con = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        
    }
}
