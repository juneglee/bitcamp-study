package com.eomcs.spring.ioc.ex12.b;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.FactoryBean;

// SqlSessionFactory를 팩토리 클래스 장점
// 각각의 저장 장소를 하나씩 지정해야 하는 불편함을 줄이고,
// 유지 보수를 쉽게 하기 위해서 분리하여 만든다.
// FactoryBean이라는 클래스가 만들어지면 FactoryBean앞에 있는 것을 리턴한다
public class SqlSessionFactoryFactoryBean 
implements FactoryBean<SqlSessionFactory> {

  String configLocation;

  public void setConfigLocation(String configLocation) {
    this.configLocation = configLocation;
  }

  @Override
  public SqlSessionFactory getObject() throws Exception {
    InputStream in = Resources.getResourceAsStream(configLocation);
    return new SqlSessionFactoryBuilder().build(in);
  }

  @Override
  public Class<?> getObjectType() {
    return SqlSessionFactory.class;
  }
}
