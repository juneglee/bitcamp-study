package com.eomcs.sql;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class MybatisDaoFactory {

  InvocationHandler invocationHandler;

  public MybatisDaoFactory(SqlSessionFactory sqlSessionFactory) {
    invocationHandler = (proxy, method, args) -> {
      // 할 일: SqlSession을 이용하여 SQL을 실행한다.
      // 준비물:
      // 1) 실행할 SQL의 namespace와 id
      // 2) select 목록/select 한 개/insert/update/delete 여부
      //
      // 동작원리:
      // 1) 인터페이스명과 메서드명을 이용하여 실행할 SQL 아이디를 알아낸다.
      // 2) 리턴 타입에 따라 호출할 메서드를 결정한다.
      // 3) 파라미터 유무에 따라 메서드에 넘길 항목을 결정한다.


      // => SQL ID 알아내기
      Class<?> clazz = proxy.getClass(); // 프록시 객체의 정보를 알아낸다.
      Class<?> daoInterface = clazz.getInterfaces()[0]; // 프록시 객체가 구현한 인터페이스 정보를 알아낸다.
      String interfaceName = daoInterface.getName();
      String methodName = method.getName();
      String sqlId = String.format("%s.%s", interfaceName, methodName);
      System.out.println(sqlId);

      // => 리턴 타입에 따라 메서드를 호출한다.
      try (SqlSession sqlSession = sqlSessionFactory.openSession()) {

        Class<?> returnType = method.getReturnType();
        if (returnType == List.class) {
          return (args == null) ? sqlSession.selectList(sqlId) : //
          sqlSession.selectList(sqlId, args[0]);
        } else if (returnType == int.class || returnType == void.class) {
          return (args == null) ? sqlSession.update(sqlId) : //
          sqlSession.update(sqlId, args[0]);

        } else {
          return (args == null) ? sqlSession.selectOne(sqlId) : //
          sqlSession.selectOne(sqlId, args[0]);
        }
      }
    };
  }
  // 객체 생성된 것을 담는 공간을 생성한다

  @SuppressWarnings("unchecked")
  public <T> T createDao(Class<T> daoInterface) {
    // public Object createDao(Class<?> daoInterface) {
    // ?를 사용하면 아무 클래스를 사용할 수 있지만 T라는 인터페이가 넘어오면
    // T는 클래스 이름을 담고 있는 변수라고 생각하면된다.
    // 즉 파라미터마다 Class<T> 타입 다르고
    // 각각의 파라미터마다 리턴되는 값이 다르기 떄문에 특정값의 <T> T라고 앞에 정보를 준다
    return (T) Proxy.newProxyInstance(//
        this.getClass().getClassLoader(), //
        new Class[] {daoInterface}, //
        invocationHandler);
  }
}

