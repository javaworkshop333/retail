package com.hibernate.springdata;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.hibernate.LoginEntity;

@Repository
public interface LoginRepository extends JpaRepository<LoginEntity, String> {
	public List<LoginEntity> findByUidAndPwd(String users,String password);
	
	public List<LoginEntity> findByUid(String users);
	
	// JPQL
	@Query("SELECT u FROM LoginEntity u WHERE u.uid= ?1 and u.pwd=?2")
	public List<LoginEntity> verify(String users,String password);
	
	//SQL
	@Query(value="SELECT * FROM users WHERE user= ?1 and password=?2",nativeQuery = true)
	public List<LoginEntity> nativeVerify(String users,String password);

	@Transactional
	@Modifying
	@Query("UPDATE LoginEntity u SET u.pwd=?2 WHERE u.uid= ?1")
	public int update(String users,String password);
	
	@Transactional
	@Modifying
	@Query("DELETE LoginEntity u WHERE u.uid= ?1")
	public int delete(String users);
	
			
}
