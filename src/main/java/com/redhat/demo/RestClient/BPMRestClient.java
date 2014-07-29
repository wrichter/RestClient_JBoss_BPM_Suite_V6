package com.redhat.demo.RestClient;



import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.services.client.api.RemoteRestRuntimeFactory;
import org.kie.api.runtime.process.ProcessInstance;

import com.redhat.demo.heisedemo.Personendaten;
import com.redhat.demo.heisedemo.VersichertesObjekt;
import com.redhat.demo.heisedemo.Vertrag;


public class BPMRestClient {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws MalformedURLException {
		
		RemoteRestRuntimeFactory restSessionFactory = new RemoteRestRuntimeFactory("com.redhat.demo:HeiseDemo:1.4", // this can be viewed from business-central -> properties of deployed Process
				 																	new URL("http://localhost:49160/business-central"), 
				 																	"psteiner", "change12_me");

		// Create Variables
		Personendaten person = new Personendaten("admin", "Patrick","Steiner",new java.util.Date(), "p@p.de", "Strasse", 21244, "Hamburg", "iban", "bic","tel");
		VersichertesObjekt objekt = new VersichertesObjekt(new java.util.Date(), 200, "efh", "strasse", 21244, "Hamburg"); 
		Vertrag vertrag = new Vertrag(0.0, 0, "Premium", "0" );
		
        // create REST request
        RuntimeEngine engine = restSessionFactory.newRuntimeEngine();
        KieSession ksession = engine.getKieSession();
      
        Map<String, Object> params = new HashMap<String, Object>();
        
        params.put("personendaten", person);
        params.put("versichertesObjekt", objekt);
        params.put("vertrag", vertrag);
        
       ProcessInstance processInstance = ksession.startProcess("HeiseDemo.Hausrat", params);

//        System.out.println("Started process instance: " + processInstance + " " + (processInstance == null ? "" : processInstance.getId()));

        System.out.print("foo");
	}

}
