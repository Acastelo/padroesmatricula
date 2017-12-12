package com.j7ss.core;

import java.io.IOException;
import java.util.Locale;

import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class WebContext {
	
	public static FacesContext getCurrentInstance(){
		return FacesContext.getCurrentInstance();
	}
	
	public static UIViewRoot getViewRoot(){
		return getCurrentInstance().getViewRoot();
	}
	
	public static void redirect(String page) throws IOException{
		getCurrentInstance().getExternalContext().redirect(page);
	}
	
	public static ExternalContext getExternalContext(){
		return getCurrentInstance().getExternalContext();
	}
	
	public static Locale getLocale(){
		return getViewRoot().getLocale();
	}
	
	public static HttpSession getSession(){
		return ((HttpSession) getExternalContext().getSession(true));
	}
	
	public static void invalidateSession(){
		getSession().invalidate();
	}
	
	public static void setFlash(String key, Object value){
		getExternalContext().getFlash().put(key, value);
	}
	
	public static Object getFlash(String key){
		return getExternalContext().getFlash().get(key);
	}
}
