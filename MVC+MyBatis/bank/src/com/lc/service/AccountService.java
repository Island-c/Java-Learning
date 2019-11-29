package com.lc.service;

import java.io.IOException;

import com.lc.pojo.Account;

public interface AccountService {
	/**
	 * 账号密码不匹配的状态码
	 */
	int ACCOUNT_PASSWORD_NOT_MATCH = 1;

	/**
	 * 余额不足
	 */
	int ACCOUNT_BALANCE_NOT_ENOUGH = 2;

	/**
	 * 账户和姓名不匹配
	 */
	int ACCOUNT_NAME_NOT_MATCH=3;
	
	/**
	 * 转账失败
	 */
	int ERROR=4;
	
	/**
	 * 转账成功
	 */
	int SUCCESS=5;
	
	/**
	 * 
	 * @param accIn  收款账号
	 * @param accOut 转出账号
	 * @return
	 * @throws IOException
	 */
	int transfer(Account accIn, Account accOut) throws IOException;

}
