package com.redhat.demo.RestClient;



import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.services.client.api.RemoteRestSessionFactory;
import org.kie.api.runtime.process.ProcessInstance;


public class BPMRestClient {

	public static void main(String[] args) throws MalformedURLException {
		
		RemoteRestSessionFactory restSessionFactory = new RemoteRestSessionFactory("com.redhat.bpms.examples:mortgage:1", // this can be viewed from business-central -> properties of deployed Process
				 																	new URL("http://localhost:8080/business-central"), 
				 																	"erics", "bpmsuite");

        // create REST request
        RuntimeEngine engine = restSessionFactory.newRuntimeEngine();
        KieSession ksession = engine.getKieSession();
      
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", "Hans Hanussen");
        params.put("address", "Somewhere");
        params.put("ssn", 1234567);
        params.put("income", 40);
        params.put("price", 400000);
        params.put("downPayment", 100000);
        params.put("amortization", 10);
        
        ProcessInstance processInstance = ksession.startProcess("com.redhat.bpms.examples.mortgage.MortgageApplication", params);

        System.out.println("Started process instance: " + processInstance + " " + (processInstance == null ? "" : processInstance.getId()));

	}

}
