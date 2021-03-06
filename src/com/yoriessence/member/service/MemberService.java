package com.yoriessence.member.service;

import static com.yoriessence.common.JDBCTemplate.close;
import static com.yoriessence.common.JDBCTemplate.getConnection;
import static com.yoriessence.common.JDBCTemplate.rollback;
import static com.yoriessence.common.JDBCTemplate.commit;

import java.sql.Connection;

import com.yoriessence.member.dao.MemberDao;
import com.yoriessence.member.vo.Member;


public class MemberService {
	private MemberDao dao=new MemberDao();
	
	public Member login(String userId, String userPwd) {
		Connection conn=getConnection();
		Member m = dao.login(conn,userId,userPwd);
		close(conn);
		return m;
	}
	
	public int insertMember(Member m) {
		Connection conn=getConnection();
		int result=dao.insertMember(conn, m);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	public Member checkDuplicateId(String userId) {
		Connection conn=getConnection();
		Member m = dao.checkDuplicateId(conn,userId);
		close(conn);
		return m;
	}
	public Member checkDuplicateName(String userName) {
		Connection conn=getConnection();
		Member m = dao.checkDuplicateName(conn,userName);
		close(conn);
		return m;
	}
	public Member checkDuplicateNick(String userNcik) {
		Connection conn=getConnection();
		Member m = dao.checkDuplicateNick(conn,userNcik);
		close(conn);
		return m;
	}
	public int updateMember(Member m) {
		Connection conn=getConnection();
		int result = dao.updateMember(conn, m);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
		
	}
	public int updatePassword(String userId, String newPw) {
		Connection conn=getConnection();
		int result = dao.updatePassword(conn, userId, newPw);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
		
	}
	public Member SearchKakaoMember(String kakaoUserId, String kakaoUserEmail, String kakaoUserName) {
		Connection conn=getConnection();
		Member m=dao.SearchKakaoMember(conn, kakaoUserId, kakaoUserEmail, kakaoUserName);
		close(conn);
		return m;
	}
}