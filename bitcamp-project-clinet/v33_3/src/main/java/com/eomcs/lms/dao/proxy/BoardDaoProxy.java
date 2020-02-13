package com.eomcs.lms.dao.proxy;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.dao.Worker;
import com.eomcs.lms.domain.Board;

// 프록시 객체는 항상 작업 객체와 동일한 인터페이스를 구현해야 한다
// => 마치 자신이 작업 객체 인양 보이기 위함이다
public class BoardDaoProxy implements BoardDao {

  DaoProxyHelper daoProxyHelper;


  public BoardDaoProxy(DaoProxyHelper daoProxyHelper) {
    this.daoProxyHelper = daoProxyHelper;
  }

  @Override
  public int insert(Board board) throws Exception {
    class InsertWorker implements Worker {
      // 중첩 클래스를 정의한 이유?
      // 중첩 클래스를 안의 파라미터를 사용하기 위해서는
      // 인터페이스를 구현한 중첩클래스를 구현하여야 한다
      @Override
      public Object execute(ObjectInputStream in, ObjectOutputStream out) throws Exception {
        out.writeUTF("/board/add");
        out.writeObject(board);
        out.flush();

        String response = in.readUTF();
        if (response.equals("FAIL")) {
          throw new Exception(in.readUTF());
        }
        return 1;
      }
    }
    InsertWorker worker = new InsertWorker();

    int resultState = (int) daoProxyHelper.request(worker); // un boxing
    return resultState;
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Board> findAll() throws Exception {
    Worker worker = new Worker() { // 익명 클래스

      @Override
      public Object execute(ObjectInputStream in, ObjectOutputStream out) throws Exception {
        out.writeUTF("/board/list");
        out.flush();
        String response = in.readUTF();
        if (response.equals("FAIL")) {
          throw new Exception(in.readUTF());
        }
        return in.readObject();
      }
    };
    Object result = daoProxyHelper.request(worker);
    return (List<Board>) result;
  }

  @Override
  public Board findByNo(int no) throws Exception {
    Object result = daoProxyHelper.request(new Worker() {

      @Override
      public Object execute(ObjectInputStream in, ObjectOutputStream out) throws Exception {
        out.writeUTF("/board/detail");
        out.writeInt(no);
        out.flush();
        String response = in.readUTF();
        if (response.equals("FAIL")) {
          throw new Exception(in.readUTF());
        }
        return in.readObject();
      }
    });
    return (Board) result;
  }

  @Override
  public int update(Board board) throws Exception {
    return (int) daoProxyHelper.request(new Worker() {

      @Override
      public Object execute(ObjectInputStream in, ObjectOutputStream out) throws Exception {
        out.writeUTF("/board/update");
        out.writeObject(board);
        out.flush();

        String response = in.readUTF();
        if (response.equals("FAIL")) {
          throw new Exception(in.readUTF());
        }
        return 1;
      }
    });
  }

  @Override
  public int delete(int no) throws Exception {
    return (int) daoProxyHelper.request((in, out) -> {
      out.writeUTF("/board/delete");
      out.writeInt(no);
      out.flush();

      String response = in.readUTF();
      if (response.equals("FAIL")) {
        throw new Exception(in.readUTF());
      }
      return 1;
    });

  }
}
