package com.jaxrs.anime;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.annotation.PostConstruct;
import javax.management.MalformedObjectNameException;
import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.NotCompliantMBeanException;
import java.lang.InterruptedException;
import javax.management.MBeanServer;
import java.lang.management.ManagementFactory;
import javax.management.ObjectName;


@Singleton
@Startup
public class LabaInit{
	@PostConstruct
	public void init() throws MalformedObjectNameException, InstanceAlreadyExistsException, MBeanRegistrationException, NotCompliantMBeanException, InterruptedException{
		MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
		ObjectName name = new ObjectName("com.jaxrs.anime:type=Laba");
		Laba mbean = new Laba();
		mbs.registerMBean(mbean, name);
		ObjectName distance = new ObjectName("com.jaxrs.anime:type=Distance");
		Distance mbeandis = new Distance();
		mbs.registerMBean(mbeandis, distance);
	}
}