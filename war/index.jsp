<%@page import="java.util.Enumeration"%><%@page import="java.util.Locale"
%><%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%
	
   String language = "en";
   String headerLanguage = request.getHeader("Accept-Language");
   if (headerLanguage != null)
   {
      Enumeration<Locale> locales = request.getLocales();
      while (locales.hasMoreElements())
      {
         String localeLang = locales.nextElement().getLanguage();
         if (localeLang.equals("en") ||localeLang.equals("it") ||localeLang.equals("de") )
         {
            language = localeLang;
            break;
         }
      }
   }
   response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
   response.setHeader("Location", language);
%>