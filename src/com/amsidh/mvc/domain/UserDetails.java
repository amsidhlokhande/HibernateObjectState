package com.amsidh.mvc.domain;

import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;

@Entity
@NamedQueries({ @NamedQuery(name = "getUserDetails.ByUserId", query = "from UserDetails where userId = :userId") })
@NamedNativeQueries({
		@NamedNativeQuery(name = "getUser.ByUserName", query = "select * from UserDetails where userName like :userName", resultClass = UserDetails.class),
		@NamedNativeQuery(name = "byUserName", query = "select * from UserDetails where userId = :userId", resultSetMapping = "byUserNameSqlMapping")

})
@SqlResultSetMappings({ @SqlResultSetMapping(name = "byUserNameSqlMapping", entities = {
		@EntityResult(entityClass = UserDetails.class, fields = { @FieldResult(name = "userId", column = "userId"),
				@FieldResult(name = "userName", column = "userName") }) }) })
@org.hibernate.annotations.Entity(selectBeforeUpdate = true)
public class UserDetails {

	@Id
	private Integer userId;
	private String userName;

	public UserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDetails(Integer userId, String userName) {
		super();
		this.userId = userId;
		this.userName = userName;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
