package com.lc.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import com.lc.pojo.Account;
import com.lc.pojo.Log;
import com.lc.service.AccountService;

public class AccountServiceImpl implements AccountService{

	@Override
	public int transfer(Account accIn, Account accOut) throws IOException {
		InputStream is =Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory =new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		
		//判断账号和密码是否匹配
		Account accOutSelect = session.selectOne("com.lc.mapper.AccountMapper.selByAccnoPwd",accOut);
		
		if(accOutSelect != null) {
			//账号验证成功 开始判断余额是否足够
			if(accOutSelect.getBalance()>=accOut.getBalance()) {
				//余额充足
				Account accInSelect = session.selectOne("com.lc.mapper.AccountMapper.selByAccnoName",accIn);
				if(accInSelect != null) {
					//收款账户正确
					accOut.setBalance(-accOut.getBalance()); //扣费，转成负数
					int index = session.update("com.lc.mapper.AccountMapper.updBalanceByAccno",accOut);
					index += session.update("com.lc.mapper.AccountMapper.updBalanceByAccno",accIn);
					if(index ==2) {
						//成功
						
						//记录日志
						Log log= new Log(0,accIn.getAccNo(),accOut.getAccNo(),accIn.getBalance());
						session.insert("com.lc.mapper.LogMapper.addLog",log);
						
						Logger logger= Logger.getLogger(this.getClass());
						SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
						logger.info(log.getAccOut()+"给"+log.getAccIn()+"在"+dateFormat.format(new Date())+"转了"+log.getMoney());
						
						session.commit(); //提交事务
						session.close();
						return SUCCESS;
						
					}else {
						//失败， 事务回滚
						session.rollback();
						return ERROR;
					}
					
					
				}else {
					//收款账户错误
					return ACCOUNT_NAME_NOT_MATCH;
				}
				
			}else {
				//余额不足
				return ACCOUNT_BALANCE_NOT_ENOUGH;
			}
		}else {
			//账号密码不匹配  返回
			return ACCOUNT_PASSWORD_NOT_MATCH;
		}
		
	}
}
