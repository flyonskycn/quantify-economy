/**
 * 
 */
package com.flyonsky.quantify.service;

import java.util.List;

import com.flyonsky.quantify.entity.AdminLog;
import com.flyonsky.quantify.entity.AdminRole;
import com.flyonsky.quantify.entity.AdminRoleUrl;
import com.flyonsky.quantify.entity.AdminUrl;
import com.flyonsky.quantify.entity.AdminUser;
import com.flyonsky.quantify.entity.VAdminRoleAllUrl;
import com.flyonsky.quantify.entity.VAdminRoleAllUser;
import com.flyonsky.quantify.entity.VAdminRoleUser;
import com.flyonsky.quantify.entity.VAdminUser;
import com.flyonsky.quantify.entity.VAdminUserUrl;
import com.flyonsky.quantify.model.GridData;
import com.flyonsky.quantify.model.QueryInfo;

/**
 * 管理基础接口服务
 * @author luowg
 * @date 2017年7月26日
 */
public interface AdminService {

	/**
	 * 通过管理员ID获取管理员用户信息
	 * @param adminId 管理员ID
	 * @return
	 */
	VAdminUser findAdminUser(Long adminId);
	
	/**
	 * 通过管理员用户名获取管理员用户信息
	 * @param adminName 管理员用户名获
	 * @return
	 */
	VAdminUser findAdminUser(String adminName);
	
	
	/**
	 * 查询角色
	 * @param roleid 角色ID
	 * @return
	 */
	AdminRole findAdminRole(Long roleid);
	
	/**
	 * 获取管理员的用户资源列表
	 * @param adminId 管理员ID
	 * @return
	 */
	List<VAdminUserUrl> queryAdminUserUrls(Long adminId);
	
	/**
	 * 获取角色用户列表
	 * @param roleId 角色ID
	 * @return
	 */
	List<VAdminRoleUser> queryAdminRoleUsers(Long roleId);
	
	/**
	 * 获取角色url资源列表
	 * @param roleId 角色ID
	 * @return
	 */
	List<AdminRoleUrl> queryAdminRoleUrls(Long roleId);
	
	/**
	 * 获取角色和所有用户的关系，如果没有关系urid=null
	 * @param roleId 角色ID
	 * @return
	 */
	List<VAdminRoleAllUser> queryAdminRoleAllUsers(Long roleId);
	

	/**
	 * 通过adminid获取相关所有角色信息
	 * @param adminid
	 * @return
	 */
	List<VAdminRoleUser> queryAdminRolesByAdminid(Long adminid);
	
	/**
	 * 获取角色和所有资源的关系，如果没有关系ruid=null
	 * @param roleId
	 * @return
	 */
	List<VAdminRoleAllUrl> queryAdminRoleAllUrls(Long roleId);
	
	/**
	 * 获取多个角色与所有资源的关系
	 * @param roles
	 * @return
	 */
	List<VAdminRoleAllUrl> queryAdminRolesAllUrls(String roles);
	/**
	 * 分页查询用户列表
	 * @param user
	 * @param query 查询信息
	 * @return
	 */
	GridData<VAdminUser> queryAdminUsers(QueryInfo query);
	
	/**
	 * 分页查询角色列表
	 * @param role
	 * @param query 查询信息
	 * @return
	 */
	GridData<AdminRole> queryAdminRoles(QueryInfo query);
	
	/**
	 * 分页查询资源列表
	 * @param url
	 * @param query
	 * @return
	 */
	GridData<AdminUrl> queryAdminUrls(QueryInfo query);
	
	/**
	 * 分页查询角色用户关系
	 * @param roleUser
	 * @param query
	 * @return
	 */
	GridData<VAdminRoleUser> queryAdminRoleUsers(QueryInfo query);
	
	/**
	 * 分页查询角色资源关系
	 * @param roleUrl
	 * @param query
	 * @return
	 */
	GridData<AdminRoleUrl> queryAdminRoleUrls(QueryInfo query);
	
	/**
	 * 分页查询用户资源关系
	 * @param userUrl
	 * @param query
	 * @return
	 */
	GridData<VAdminUserUrl> queryAdminUserUrls(QueryInfo query);
	
	/**
	 * 分页查询管理用户日志
	 * @param adminLog 日志资料
	 * @param query
	 * @return 分页数据
	 */
	GridData<AdminLog> queryAdminLogs(QueryInfo query);
	
	/**
	 * 保存管理用户信息
	 * @param user 管理用户信息
	 */
	void saveUser(AdminUser user);
	
	/**
	 * 保存角色基本信息
	 * @param role
	 */
	void saveRole(AdminRole role);
	
	/**
	 * 保存角色的用户关系
	 * @param roleid 角色id
	 * @param adminIds 管理用户id列表
	 */
	void saveRoleUser(Long roleid,List<Long> adminIds);
	
	/**
	 * 保存角色的url资源关系
	 * @param roleid 角色id
	 * @param urlIds url资源列表
	 */
	void saveRoleUrl(Long roleid,List<Long> urlIds);
	
	
	/**
	 * 保存用户和其他角色关系
	 * @param adminid 角色id
	 * @param roleids 管理用户id列表
	 */
	void saveUserRole(Long adminid,List<Long> roleids);
	
	/**
	 * 保存资源和其他角色资源关系
	 * @param uid 资源ID
	 * @param roleids 角色ID列表
	 */
	void saveUrlRole(Long uid,List<Long> roleids);
	
	/**
	 * 保存日志
	 * @param log 日志
	 */
	void saveLog(AdminLog log);

	/**
	 * 修改用户登录信息
	 * @param user
	 */
	void updateUserLogin(VAdminUser user,String ip);
	
	/**
	 * 密码校验
	 * @param user
	 */
	void checkPwd(VAdminUser user);
	
	/**
	 * 保存密码
	 * @param user
	 */
	void save(VAdminUser user);
}
