package cn.tycoding.entity;

import java.io.Serializable;

/**
 * @auther TyCoding
 * @date 2018/9/28
 */
public class User implements Serializable {

    private Long id; //编号
    private String username; //用户名
    private String password; //密码
    private String role; //密码//0管理员，1是用户
    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password,String role) {
        this.username = username;
        this.password = password;
        this.role=role;
    }

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
