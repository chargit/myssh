package basic;

import java.util.List;

/**
 * Created by ww on 2017/6/30.
 */
public interface BasicServiceInter {

    public Object findById(Class clazz, java.io.Serializable id);

    public List executeQuery(String hql, Object[] parameters);

    public List executeQueryByPage(String hql, Object[] parameters, int pageNow, int pagesSize);

    public void add(Object obj);

    public List executeUpdate(String hql, Object[] parameters);

    public Object uniqueQuery(String hql, Object[] parameters);

    public int queryPageCount(String hql, Object[] parameters, int pageSize);

    public void delById(Class clazz, java.io.Serializable id);

    public void update(Object object);
}
