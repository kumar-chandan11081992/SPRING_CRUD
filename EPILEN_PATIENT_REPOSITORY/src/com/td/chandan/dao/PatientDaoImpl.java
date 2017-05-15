package com.td.chandan.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.td.chandan.model.Patient;

/**
 * @author Kumar Chandan
 *
 */
@Repository("patientDao")
public class PatientDaoImpl implements PatientDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addPatient(Patient patient) {
		sessionFactory.getCurrentSession().saveOrUpdate(patient);
	}

	@SuppressWarnings("unchecked")
	public List<Patient> listPatients() {
		return (List<Patient>) sessionFactory.getCurrentSession().createCriteria(Patient.class).list();
	}

	public Patient getPatient(int patientid) {
		//return (Patient) sessionFactory.getCurrentSession().get(Patient.class, patientid);
		//return  sessionFactory.getCurrentSession().createCriteria(Patient.class).add(Restrictions.eq("patientid", 1));
		//return (Patient) sessionFactory.getCurrentSession().createQuery("SELECT * FROM Patient WHERE patientid = "+patientid);
		//Query q1= sessionFactory.getCurrentSession().createQuery("SELECT FROM Patient WHERE patientid = "+patientid);
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Patient.class);
		cr.add(Restrictions.eq("patientId", patientid));
		List patients = cr.list();
		Patient p1=new Patient();
		
		 for (Iterator iterator = patients.iterator(); iterator.hasNext();)
		 {
			 p1 = (Patient) iterator.next(); 
			 break;
		 }
		
		return p1;
	}

	public void deletePatient(Patient patient) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Patient WHERE patientid = "+patient.getPatientId()).executeUpdate();
	}

	public void selectPatient(Patient patient)
	{
		
		sessionFactory.getCurrentSession().createQuery("SELECT FROM Patient WHERE patientid = "+patient.getPatientId()).executeUpdate();
		
	}
}
