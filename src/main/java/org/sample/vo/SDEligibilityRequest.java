package org.sample.vo;

import java.util.Set;

import org.apache.commons.collections.CollectionUtils;


public class SDEligibilityRequest {

	private Set<String> actions;
	private Set<ActionParam> params;
	
	
	public Set<String> getActions() {
		return actions;
	}
	public void setActions(Set<String> actions) {
		this.actions = actions;
	}
	public Set<ActionParam> getParams() {
		return params;
	}
	public void setParams(Set<ActionParam> params) {
		this.params = params;
	}
	
	@Override
	public String toString() {
		
		StringBuilder requestActions = new StringBuilder();
		StringBuilder requestAuthParams = new StringBuilder();
		
		if(CollectionUtils.isNotEmpty(this.actions)){
			for(String action : this.actions)
				requestActions.append(action+" ");
		}
		
		
		if(CollectionUtils.isNotEmpty(this.params)){
			for(ActionParam param : this.params)
				requestAuthParams.append(param.getEt()+" "+param.getSid()+" ");
		}
		
		return "Eligibility :: actions-> "+requestActions.toString()+" : authParams-> "+requestAuthParams.toString();
	}
	
}
