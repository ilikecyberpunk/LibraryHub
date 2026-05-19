import java.sql.*;

public class LoanDAOImpl implements LoanDAO {
    public void registerLoan(int bookId, int memberId){
        Connection con = DBConnection.getConnection();
        PreparedStatement st = null;
        
        String sql = "INSERT INTO LOAN(LOAN_ID, BOOK_ID, MEMBER_ID, LOAN_DATE) VALUES(LOAN_SEQ.NEXTVAL, ?, ?, SYSDATE)";
        try{
            st = con.prepareStatement(sql);
            st.setInt(1,bookId);
            st.setInt(2, memberId);
        }
        catch(Exception e){
            System.out.println(e);
        }
        finally{
            DBConnection.close(con, st, null);
        }
        System.out.println("멤버 id = "+memberId+", 책 id = "+bookId+"대출등록 성공");
    }
    public void returnBook(int loanId, int bookId){
        
    }
    public void getOverdueList(){

    }
}
