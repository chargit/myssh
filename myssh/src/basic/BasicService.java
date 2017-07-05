package basic;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

/**
 * Created by ww on 2017/6/30.
 */
@Transactional
public class BasicService implements  BasicServiceInter {

    @Resource
    private SessionFactory sessionFactory;


    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public Object findById(Class clazz, Serializable id) {
        return this.sessionFactory.getCurrentSession().get(clazz, id);
    }

    public List executeQuery(String hql, Object[] parameters) {

        Query query = this.sessionFactory.getCurrentSession().createQuery(hql);

        if(parameters!=null && parameters.length>0){

            for(int i=0;i<parameters.length;i++){

                query.setParameter(i,parameters[i]);

            }
        }

        return query.list();

    }

    public List executeQueryByPage(String hql, Object[] parameters, int pageNow, int pagesSize) {

        Query query = this.sessionFactory.getCurrentSession().createQuery(hql);

        if(parameters!=null && parameters.length>0){

            for(int i=0;i<parameters.length;i++){

                query.setParameter(i,parameters[i]);

            }
        }

        return query.setFirstResult((pageNow-1)*pagesSize).setMaxResults(pagesSize).list();

    }

    public void add(Object obj) {

        this.sessionFactory.getCurrentSession().save(obj);

    }

    public List executeUpdate(String hql, Object[] parameters) {
        return null;
    }


    public Object uniqueQuery(String hql, Object[] parameters) {

        Query query = this.sessionFactory.getCurrentSession().createQuery(hql);

        if(parameters!=null&& parameters.length>0){

            for(int i=0;i<parameters.length;i++){

                query.setParameter(i,parameters[i]);
            }

        }
        return query.uniqueResult();
    }


    public int queryPageCount(String hql, Object[] parameters, int pageSize) {

        Object obj = this.uniqueQuery(hql, parameters);
        int rowCount = Integer.parseInt(obj.toString());

        return (rowCount-1)/pageSize+1;

    }


    public void delById(Class clazz, Serializable id) {

        Session session = this.sessionFactory.getCurrentSession();

        session.delete(this.findById(clazz, id));

    }


    public void update(Object object) {

        this.sessionFactory.getCurrentSession().update(object);
    }

}
