package com.bbva.wikj.lib.r030;

import com.bbva.elara.configuration.manager.application.ApplicationConfigurationService;
import com.bbva.elara.domain.transaction.Context;
import com.bbva.elara.domain.transaction.ThreadContext;
import javax.annotation.Resource;

import com.bbva.wikj.dto.evaluacion.evaluaciondos.EntradaDTO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.aop.framework.Advised;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/META-INF/spring/WIKJR030-app.xml",
		"classpath:/META-INF/spring/WIKJR030-app-test.xml",
		"classpath:/META-INF/spring/WIKJR030-arc.xml",
		"classpath:/META-INF/spring/WIKJR030-arc-test.xml" })
public class WIKJR030Test {

	@Spy
	private Context context;

	@Resource(name = "wikjR030")
	private WIKJR030 wikjR030;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		context = new Context();
		ThreadContext.set(context);
		getObjectIntrospection();
	}
	
	private Object getObjectIntrospection() throws Exception{
		Object result = this.wikjR030;
		if(this.wikjR030 instanceof Advised){
			Advised advised = (Advised) this.wikjR030;
			result = advised.getTargetSource().getTarget();
		}
		return result;
	}
	
	@Test
	public void executeTest(){
		wikjR030.execute(mapperEntrada());
		Assert.assertEquals(0, context.getAdviceList().size());
		System.out.println(wikjR030.execute(mapperEntrada()));
	}
	public static EntradaDTO mapperEntrada(){
		EntradaDTO entradaDTO = new EntradaDTO();
		entradaDTO.setFrequency("M");
		entradaDTO.setNumberInstalments(4);
		entradaDTO.setAmount(20000);
		entradaDTO.setPercentageInterest(50);
		return entradaDTO;
	}

	public void executeTest2(){
		wikjR030.execute(mapperEntrada2());
		Assert.assertEquals(0, context.getAdviceList().size());
		System.out.println(wikjR030.execute(mapperEntrada()));
	}
	public static EntradaDTO mapperEntrada2(){
		EntradaDTO entradaDTO = new EntradaDTO();
		entradaDTO.setFrequency("A");
		entradaDTO.setNumberInstalments(24);
		entradaDTO.setAmount(1000000);
		entradaDTO.setPercentageInterest(10);
		return entradaDTO;
	}
	
}
